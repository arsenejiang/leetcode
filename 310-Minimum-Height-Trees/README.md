First, get adj list from all the edges.
Then use a neighbors array to capture number of neighbors for each vertex.
Add all vertexes whose number of neighbors = 1 to result, for each vertex in the result, decrease neighbor count for its neighbors such as "removing leave nodes". Then keep going to "remove leaves" until we get 1 or 2 vertex.