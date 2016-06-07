package died2016.grafos.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public class Auxiliar {
/*
 * 
//	/*
//	 * Ejemplo: ordenar los cursos de una carrera universitaria en una 
//	 * secuencia que no viole los prerrequisitos.
//	 * El algoritmo consiste en encontrar primero un vrtice v que no
//	 * tenga aristas de entrada.
//	 * Se imprime este vrtice y se borra lgicamente del grafo junto con sus aristas.
//	 * Luego, se sigue aplicando la misma estrategia al resto del grafo.
//	 * Se utiliza el grado de entrada de cada vrtice v ( nmero de aristas (u,v)) 
//	 * el que se decrementa en 1 al borrar lgicamente 
//	 * 
//	 */
//	public List<T> ordenTopologico(){
//		List<T> resultado = new ArrayList<T>();
//		Map<T, Integer> gradoPorNodo = new HashMap<T, Integer>();
//		for(Vertice<T> v : this.vertices){
//			gradoPorNodo.put(v.getValor(), this.gradoEntrada(v.getValor()));
//		}
////		for(Vertice<T> vert : this.vertices){
//		while(!gradoPorNodo.isEmpty()){
//			for(T vert : gradoPorNodo.keySet()){
//				if(gradoPorNodo.get(vert)==0) {
//					resultado.add(vert);
//					for(T v: this.getAdyacentes(vert)){
//						int aux = gradoPorNodo.get(v);
//						gradoPorNodo.put(v, aux-1);
//					}
//					gradoPorNodo.remove(vert);
//				}
//			}
//		}		
//		return resultado;
//	}
//
//	public List<T> recorridoAnchura(T n1){
//		//obtengo el nodo desde donde comienza el recorrido
//		Vertice<T> inicial = this.getNodo(n1);
//		
//		// armo un map donde marco cada nodo como no visitado
//		Map<Vertice<T>, Boolean> visitado = new HashMap<Vertice<T>, Boolean>();
//		for(Vertice<T> n : this.vertices){
//			visitado.put(n, false);
//		}
//		
//		//creo la cola para almacenar los nodos pendientes de visitar.
//		Queue<Vertice<T>> pendientes = new LinkedList<Vertice<T>>();
//		//creo la lista de resultados.
//		List<T> resultado = new ArrayList<T>();
//
//		// tomo el primer nodo y lo marco como visitado
//		visitado.put(inicial, true);
//		// y lo agrego a los pendientes a visitar
//		pendientes.add(inicial);
//		
//		while(!pendientes.isEmpty()){			
//			//quito el nodo pendiente
//			Vertice<T>  nodoActual= pendientes.remove();
//			// lo agrego a los resultados
//			resultado.add(nodoActual.getValor());
//			for(Vertice<T> n : this.getAdyacentes(nodoActual)){
//				/* 
//				 * a cada adyacente del nodo visitado lo agrego 
//				 * a la cola de los pendientes 
//				 * si no fue visitado y lo marco como visitado
//				 */
//				if(!visitado.get(n)){ 
//					pendientes.add(n);
//					visitado.put(n,true);
//				}
//				
//			}
//		}
//		return resultado;
//	}
//
//	public List<T> recorridoProfundidad(T n1){
//		//obtengo el nodo desde donde comienza el recorrido
//		Vertice<T> inicial = this.getNodo(n1);
//		
//		// armo un map donde marco cada nodo como no visitado
//		Map<Vertice<T>, Boolean> visitado = new HashMap<Vertice<T>, Boolean>();
//		for(Vertice<T> n : this.vertices){
//			visitado.put(n, false);
//		}
//		
//		//creo la cola para almacenar los nodos pendientes de visitar.
//		Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
//		//creo la lista de resultados.
//		List<T> resultado = new ArrayList<T>();
//
//		// tomo el primer nodo y lo marco como visitado
//		visitado.put(inicial, true);
//		// y lo agrego a los pendientes a visitar
//		pendientes.add(inicial);
//		
//		while(!pendientes.isEmpty()){			
//			//quito el nodo pendiente
//			Vertice<T>  nodoActual= pendientes.pop();
//			// lo agrego a los resultados
//			resultado.add(nodoActual.getValor());
//			for(Vertice<T> n : this.getAdyacentes(nodoActual)){
//				/* 
//				 * a cada adyacente del nodo visitado lo agrego 
//				 * a la pila de los pendientes 
//				 * si no fue visitado y lo marco como visitado
//				 */
//				if(!visitado.get(n)){ 
//					pendientes.push(n);
//					visitado.put(n,true);
//				}
//				
//			}
//		}
//		return resultado;
//	}
//	
//	
//	public List<T> recorridoProfundidadAll(T n1,T n2){
//		//obtengo el nodo desde donde comienza el recorrido
//		Vertice<T> inicial = this.getNodo(n1);
//		
//		// armo un map donde marco cada nodo como no visitado
//		Map<Vertice<T>, Boolean> visitado = new HashMap<Vertice<T>, Boolean>();
//		for(Vertice<T> n : this.vertices){
//			visitado.put(n, false);
//		}
//		
//		//creo la cola para almacenar los nodos pendientes de visitar.
//		Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
//		//creo la lista de resultados.
//		List<T> resultado = new ArrayList<T>();
//
//		// tomo el primer nodo y lo marco como visitado
//		visitado.put(inicial, true);
//		// y lo agrego a los pendientes a visitar
//		pendientes.add(inicial);
//		
//		while(!pendientes.isEmpty()){			
//			//quito el nodo pendiente
//			Vertice<T>  nodoActual= pendientes.pop();
//			// lo agrego a los resultados
//			resultado.add(nodoActual.getValor());
//			for(Vertice<T> n : this.getAdyacentes(nodoActual)){
//				/* 
//				 * a cada adyacente del nodo visitado lo agrego 
//				 * a la pila de los pendientes 
//				 * si no fue visitado y lo marco como visitado
//				 */
//				if(!visitado.get(n)){ 
//					pendientes.push(n);
//					visitado.put(n,true);
//				}
//				
//			}
//		}
//		return resultado;
//	}
//	
//	public List<List<T>> todosLosCaminosViejo(T inicio,T fin){
//		List<List<T>> salida = new ArrayList<List<T>>();
//		Vertice<T> nodoInicial = this.getNodo(inicio);
//		Vertice<T> nodoFinal = this.getNodo(fin);
//		
//		//chequeo si existe camino directo entre origen y final.
//		// chequeo si existe un camino desde algn adyacente.
//		for(Vertice<T> n1 : this.getAdyacentes(nodoInicial)){
//				List<T> camino = new ArrayList<T>();
//				camino.add(nodoInicial.getValor());
//				//si un adyacente ya es destino lo agrego
//				if(n1.equals(nodoFinal)){
//					camino.add(nodoFinal.getValor());
//					salida.add(camino);
//				}
//				//sigo buscando camino por el adyacente
//				else{
//					List<List<T>> aux = camino2(n1,nodoFinal);
//					if(aux!=null){
////						camino.addAll(aux);
//						salida.addAll(aux);
//					}
//				}
//		}
//		return salida;
//	}
//	
//	public List<List<T>> todosLosCaminosNuevo(T inicio,T fin){
//		List<List<T>> salida = new ArrayList<List<T>>();
//		List<T> caminoActual = new ArrayList<T>();
//		Vertice<T> nodoInicial = this.getNodo(inicio);
//		Vertice<T> nodoFinal = this.getNodo(fin);
//		caminoActual.add(nodoInicial.getValor());
//		caminoAux(nodoInicial,nodoFinal,caminoActual,salida);
//		return salida;
//	}
//	
//	private void caminoAux(Vertice<T> origen,Vertice<T> destino, List<T> marcados,List<List<T>> camino){
//		
//		for(Vertice<T> n1 : this.getAdyacentes(origen)){
//			if(n1.equals(destino)){
//				marcados.add(n1.getValor());				
//			}else{				
//				if(!marcados.contains(n1.getValor())){
//					marcados.add(n1.getValor());
//					caminoAux(origen, destino, marcados, camino);
//				}
////				marcados.remove(n1.getValor());
//			}
//		}
//		
//	}	
//	
//	private List<T> camino3(Vertice<T> origen,Vertice<T> destino){
//		List<T> resultado = new ArrayList<T>();
//		for(Vertice<T> n1 : this.getAdyacentes(origen)){
//			resultado.add(origen.getValor());
//			if(n1.equals(destino)){
//				resultado.add(destino.getValor());
//				return resultado;
//			}else{				
//				List<T> aux = camino3(n1,destino);
//				if(aux!=null) {
//					resultado.addAll(aux);
//					return resultado;
//				}else resultado.clear();
//			}
//		}
//		resultado.clear();
//		resultado = null;
//		return null;
//	}
//	
//	private List<List<T>> camino2(Vertice<T> origen,Vertice<T> destino){
//		List<List<T>> resultado = new ArrayList<List<T>>();
//		List<T> caminoEncontrado = new ArrayList<T>();
//		for(Vertice<T> n1 : this.getAdyacentes(origen)){
//			caminoEncontrado.add(origen.getValor());
//			if(n1.equals(destino)){
//				caminoEncontrado.add(destino.getValor());
//				resultado.add(caminoEncontrado);
//			}else{				
//				List<T> aux = camino3(n1,destino);
//				if(aux!=null) {
//					caminoEncontrado.addAll(aux);
//					resultado.add(caminoEncontrado);
//				}else caminoEncontrado.clear();
//			}
//		}
//		resultado.clear();
//		resultado = null;
//		return null;
//	}
//	
//	
//	/**
//	 * Chequea si tiene ciclos. 
//	 * Para esto toma cada nodo y realiza un recorrido en profundidad, pero en cada paso chequea si el nodo al cual le solicitar
//	 * los adyacentes no est en la lista de adyacentes. Si lo est hay ciclos.
//	 * @return
//	 */
//	public boolean tiene2Caminos(){
//		for(Vertice<T> vertice : this.vertices){		
//			Stack<Vertice<T>> aVisitar= new Stack<Vertice<T>>(); 
//			//para cada vertice busco el recorrido en profundidad			
//			Set<Vertice<T>> visitados = new TreeSet<Vertice<T>>();
//			aVisitar.push(vertice);			
//			while(!aVisitar.isEmpty()){				
//				Vertice<T> aux = aVisitar.pop();				
//				for(Vertice<T> ady :this.getAdyacentes(aux)){
//					if(visitados.contains(ady)) {
//						System.out.println("ciclo entre "+aux.getValor()+" : "+ady.getValor());
//						return true;
//					}else{
//						aVisitar.add(ady);
//					}
//				}
//				visitados.add(aux);
//			}						
//		}		
//		return false;
//	}
//
//	/**
//	 * Cantidad de aristas que llegan al grafo (cantidad de veces que es destino )
//	 * @param n1
//	 * @return
//	 */
//	public int gradoEntrada(T n1){
//		int grado = 0;
//		for(Arista<T> arista : this.aristas){
//			if(arista.getFin().getValor().equals(n1)) grado++;
//		}
//		return grado;
//	}
//
//	/**
//	 * Cantidad de aristas que salen del grafo (cantidad de veces que es origen ) 
//	 * @param n1
//	 * @return
//	 */
//	public int gradoSalida(T n1){
//		int grado = 0;
//		for(Arista<T> arista : this.aristas){
//			if(arista.getInicio().getValor().equals(n1)) grado++;
//		}
//		return grado;
//	}
//
//	/**
//	 * retorna trae si existe un enlace para cada par de vertices en una y solo una direccion
//	 * @return
//	 */
//	public boolean esCompleto(){
//		int i = 0;
//		for(i=0;i<this.vertices.size();i++){
//			Vertice<T> v1 = this.vertices.get(i);
//			List<Vertice<T>> adyacentesV1 = this.getAdyacentes(v1);
//			for(int j=0;j<this.vertices.size();j++){
//				Vertice<T> v2 = this.vertices.get(j);
//				List<Vertice<T>> adyacentesV2 = this.getAdyacentes(v2);
//				if(i!=j && !(adyacentesV1.contains(v2) ^ adyacentesV2.contains(v1))) return false;
//			}
//		}
//		return true;
//	}
//
//	
//	/**
//	 * retorna trae si existe un enlace para cada par de vertices en una y solo una direccion
//	 * cada vertice tiene N-1 salidas. La suma es N*N-1 y lo divido por 
//	 * @return
//	 */
//	public boolean esCompleto2(){
//		int nroVertices = this.vertices.size();
//		int nroAristas = this.aristas.size();
//		return (nroVertices*(nroVertices-1)/2)==nroAristas;
//	}
//	/**
//	 * Determina si existe un camino entre dos vrtices.
//	 * 
//	 * @param vertice1
//	 *            El nombre del vrtice inicial del camino.
//	 * @param vertice2
//	 *            El nombre del vrtice final del camino.
//	 * @return <code>true</code> si existe un camino entre los vrtices,
//	 *         <code>false</code> en caso contrario.
//	 * @throws VerticeInexistenteException
//	 *             Cuando no existe un vrtice con alguno de los nombres dados.
//	 */
//	public boolean existeCamino(T vertice1, T vertice2) {
//		List<T> adyacentes = this.getAdyacentes(vertice1);
//		Set<T> buscados = new HashSet<T>();
//		for(T unAdyacente : adyacentes){
//			if(unAdyacente.equals(vertice2)) return true;
//			else{
//				if ( existeCamino(unAdyacente, vertice2,buscados)) return true;
//			}
//		}
//		return false;
//	}
//
//
//	/**
//	 * Determina si existe un camino entre dos vrtices.
//	 * 
//	 * @param vertice1
//	 *            El nombre del vrtice inicial del camino.
//	 * @param vertice2
//	 *            El nombre del vrtice final del camino.
//	 * @return <code>true</code> si existe un camino entre los vrtices,
//	 *         <code>false</code> en caso contrario.
//	 * @throws VerticeInexistenteException
//	 *             Cuando no existe un vrtice con alguno de los nombres dados.
//	 */
//	public boolean existeCaminoIterativo(T vertice1, T vertice2) {	
//		
//		Stack<T> aBuscar = new Stack<T>();
//		aBuscar.push(vertice1);
//		Set<T> buscados = new HashSet<T>();
//		
//		while(!aBuscar.isEmpty()){
//			T aux = aBuscar.pop();			
//			List<T> adyacentes = this.getAdyacentes(aux);
//			for(T unAdyacente : adyacentes){
//				if(unAdyacente.equals(vertice2)) return true;
//				else{					
//					if(!buscados.contains(unAdyacente)){
//						buscados.add(unAdyacente);
//						aBuscar.push(unAdyacente);
//					}
//				}
//			}
//		}
//		return false;
//	}
//	
//	private boolean existeCamino(T vertice1, T vertice2,Set<T> buscados) {
//		System.out.println(vertice1+" "+vertice2+ "  BUSCADOS ("+buscados.toString()+")");
//		boolean buscar = false;
//		if(!buscados.contains(vertice1)){
//			buscados.add(vertice1);
//			buscar = true;
//		}
//		
//		List<T> adyacentes = this.getAdyacentes(vertice1);
//		System.out.println("ADY: "+adyacentes.toString());
//		for(T unAdyacente : adyacentes){
//			if(unAdyacente.equals(vertice2)) return true;
//			else{
//				if ( buscar && existeCamino(unAdyacente, vertice2,buscados)) return true;
//			}
//		}
//		return false;
//	}
//	
//	/**
//	 * Retorna una lista de todos los caminos de como mximo "n" <code>saltos<code>
//	 * que permiten ir desde el vertice1 a vertices cuyo nombre contiene el caracter "patronNombre".
//	 * 
//	 * @param vertice1
//	 *            El nombre del vrtice inicial del camino.
//	 * @param patronNombre
//	 *            Permite establecer un patrn de busqueda 
//	 * @param saltos
//	 *            Cantidad de saltos minimos.
//	 * @return una lista donde cada entrada es una lista que contiene los nombres de los vertices que conforman un camino encontrado. 
//	 *
//	 * @throws VerticeInexistenteException
//	 *             Cuando no existe un vrtice con alguno de los nombres dados.
//	 */
//	public List<List<String>> caminoMenorIgualNSaltos(String vertice1, char patronNombre,int saltos)
//			throws VerticeInexistenteException {
//		// TODO TAREA EXTRA NO OBLIGATORIA - Implementar este mtodo.
//		// TIP: para ver si un caracter est presente en un string puede usar el mtodo de string
//		// indexOf(char), que retorna -1 si no est presente, de lo contrario retorna la posicin
//		// donde dicho caracter est presente comenzando con 0
//		return null;
//	}
//	
//	public int flujoMaximo(){
//		
//	}
//
//	public List<T> caminoMasCorto(T n1,T n2){
//		return null;
//	}
//
//	public List<T> caminoMenorPeso(T n1,T n2){
//		return null;
//	}
//	
//	private int buscar(Vertice<T> v1, Vertice<T> v2){
//		   // This does a bfs to find any path with available capacity, and floods it.
//        // The amount of flow sent through is returned.
//        // If 0 is returned, we are done.
//		List<Arista<T>> camino = new ArrayList<Arista<T>>();
//        int flujoMaximoCamino =Integer.MAX_VALUE;
//        // This is a standard BFS, but we keep track of the path.
//        Set<Vertice<T>> visitados = new HashSet<Vertice<T>>();
//        Queue<Vertice<T>> tovisit = new LinkedList<Vertice<T>>();
////        tovisit.add(new ToVisit(node, null, null, Integer.MAX_VALUE));
//        tovisit.add(v1); 
//        while(!tovisit.isEmpty()) {
//            Vertice<T> visit  = tovisit.remove();
//            if(visit.equals(v2)) {
//                int flow = flujoMaximoCamino; // el maximo flujo que llevo en el reocrrido
//                // Backtrack
//                for(Arista<T> aris : camino){
//                	flow += aris.getValor().intValue();
////                  while(tv != null && tv.e != null) {
////                    tv.e.flow += flow;
////                    tv.e.reverse.flow -= flow;
////                    tv = tv.previous;
//                }
//                return flow;
//            }
//            
//            // Never visit the same node twice
//            if(visitados.contains(visit))
//                continue;
//            visitados.add(visit);
//            
//            // Forward edges
//            for(Arista a : visit.edges) {
//                if(e.capacity - e.flow > 0) {
////                    tovisit.add(new ToVisit(e.to, tv, e, Math.min(tv.maxflow, e.capacity-e.flow)));
//                }
//            }
//        }
//        return 0;
//	}
//

}
