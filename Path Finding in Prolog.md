# Path Finding in Graphs: An Example

Refer to pages 217-219 of Bratko (3rd edition). The sample material
can also be found in the 2nd edition.

 I. Path Finding 

Let G be a graph, and A and Z two nodes in G. We are interested in
a relation:

      path(A, Z, G, P)

where P is an acyclic path from A to Z in G.  

First, let us fix some representations. Assume we represent a graph by 

       graph(Nodes, Edges)

where graph is a function symbol and Nodes is a list of nodes and Edges 
is a list of directed edges in the graph. E.g.

       graph([a,b,c], [c(a,b),c(a,c),c(b,c),c(c,b)])

is a graph with three nodes and four edges where c(W,V) 
means an edge from W to V.

Then, we represent a path by a list of nodes; e.g., 
a path [a,b,c] means that the path starts 
at a and ends at c, and the path is from a to b and then to c.

An acyclic path is one in which no node appears more than once.

The relation path can be defined in terms of another relation

      path1(A, Path1, G, Path)

where A is a node, G is a graph, Path1 is a path in G, and 
Path is an acyclic path in G that goes from A to the beginning of 
Path1 and continues along Path1 up to its end.

The idea is to build Path recursively through 
graduately completing Path1
until its start node is A. 

The program can be written in Prolog as:

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
path(A, Z, Graph, Path) :- 
          path1(A, [Z], Graph, Path).

path1(A, [A|Path1], Graph, [A|Path1]).

path1(A, [Y|Path1], graph(Nodes, Edges), Path) :-
          member(c(X,Y), Edges),
          not_member(X, Path1),
          path1(A, [X,Y|Path1], graph(Nodes, Edges), Path).

not_member(X, []).
not_member(X, [Y|L]) :-
          not_member(X, L),
          X \== Y. 

member(X, [X|L]).
member(X, [Y|L]) :- member(X, L).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


To understand what this program does, try to run it, e.g, with the 
following query:

?- path(a,d,
     graph([a,b,c,d,e], 
           [c(a,b),c(b,c),c(d,c),c(b,d),c(d,b),c(d,a),c(a,e),c(e,d),c(c,d)]), 
     Path).



 II. Hamiltonian Path

A classical problem on graph theory is that of finding 
a Hamiltonian path; i.e., an acyclic path comprising all the nodes in 
the graph.  To solve this problem, we add clauses


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
hamiltonian(graph(Nodes, Edges), Path) :- 
          path(A, Z, graph(Nodes, Edges), Path),
          eq_set(Path, Nodes).

eq_set(P, N) :- 
          subset(P,N),
          subset(N,P).

subset([], S).
subset([A|L], S) :- 
         member(A, S),
         subset(L, S).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


 III. Path with Minimal Cost

Now, assume every edge has a cost associated with it, we want to find out
the shortest paths. We therefore define a predicate

      shortest_path(A,Z,G,P,C)

such that for any acyclic path P' from A to Z with cost C', C <= C'. 

For this purpose, we add the following clauses:


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
path_C(A, Z, Graph, Path, Cost) :- 
          path1_C(A, [Z], 0, Graph, Path, Cost).

path1_C(A, [A|Path1], Cost1, Graph, [A|Path1], Cost1).

path1_C(A, [Y|Path1], Cost1, graph(Nodes, Edges), Path, Cost) :-
          (member(e(X,Y), Edges); member(e(Y,X), Edges)),
          not_member(X, Path1),
          Cost2 is Cost1 + 1,
          path1_C(A, [X,Y|Path1], Cost2, graph(Nodes, Edges), Path, Cost).


shortest_path(A, Z, Graph, Path, Mini_Cost) :- 
         path_C(A, Z, Graph, Path, Mini_Cost),
         no_shorter_path(A, Z, Graph, Path1, Cost1, Mini_Cost).

no_shorter_path(A, Z, Graph, Path, Cost, Mini_Cost) :-
         not( and(A, Z, Graph, Path, Cost, Mini_Cost) ).

and(A, Z, Graph, Path, Cost, Mini_Cost) :- 
        path_C(A, Z, Graph, Path, Cost),
        Cost < Mini_Cost.

not(P) :- P, !, fail.
not(P). 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

