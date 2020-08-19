package graphiso;

import java.util.LinkedList;

public class GraphIsomorphism
{   
    /**
     * Extend a partial isomorphism p between two graphs g and h
     * @param p empty list
     * @param g adjacency matrix
     * @param h adjacency matrix
     * @return  true if and only if p was successfully extended to a full isomorphism
     */
    static boolean extend(LinkedList<Integer> p, boolean [ ][ ]g, boolean [ ][ ]h )
    {
        if(p.size() == g.length){
            return true;
        }
        for(int i = 0; i < g.length; i++){
            if(compatible(p,i,g,h)){
                p.add(p.size(),i);
                if(extend(p,g,h)){
                    return true;
                }
            }
        }
        p.removeLast();
        return false;
    }
    /**
     * 
     * @param p
     * @param v
     * @param g adjacency matrix
     * @param h adjacency matrix
     * @return true if v assigned to s, where s is p.size() extends p as an
     *              isomorphism between the graphs g and h
     */
    static boolean compatible(LinkedList<Integer> p, int v, boolean [][]g, boolean [][]h)
    {
        if(p.contains(v)){
            return false;
        }
        for(int i = 0; i < p.size(); i++){
            if(g[i][p.size()] != h[p.get(i)][v] || g[p.size()][i] != h[v][p.get(i)]){
                return false;
            }
        //System.out.print(g[i][p.size()] + " " + h[p.get(i)][v] + " true" + p.size());
        }
        return true;
    }
}

        //if graph vertex are different sizes return false
        //if v is not in p then it might be compatable
        //if the values in the other graph arnt adj then it is not compatable
        //if there is a matching edges for s,fi and fi, v
        //extend by assigning a vertex v and adding it to the linked list and assigning v to s
        //to have issomorphism adj in g1 has to have adj in g2
        //treat as directed, check both ways before crossing
           