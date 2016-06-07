package died2016.grafos.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;


public class Grafo<T> {
	private List<Arista<T>> aristas;
	private List<Vertice<T>> vertices;

	public Grafo(){
		this.aristas = new ArrayList<Arista<T>>();
		this.vertices = new ArrayList<Vertice<T>>();
	}

	public void addNodo(T nodo){
		this.addNodo(new Vertice<T>(nodo));
	}

	private void addNodo(Vertice<T> nodo){
		this.vertices.add(nodo);
	}
	
	public void conectar(T n1,T n2){
		this.conectar(getNodo(n1), getNodo(n2), 0.0);
	}

	public void conectar(T n1,T n2,Number valor){
		this.conectar(getNodo(n1), getNodo(n2), valor);
	}

	private void conectar(Vertice<T> nodo1,Vertice<T> nodo2,Number valor){
		this.aristas.add(new Arista<T>(nodo1,nodo2,valor));
	}
	
	public Vertice<T> getNodo(T valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<T>(valor)));
	}

	public List<T> getAdyacentes(T valor){ 
		Vertice<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	

	private List<Vertice<T>> getAdyacentes(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}
	
	public void imprimirAristas(){
		System.out.println(this.aristas.toString());
	}

	public Integer gradoEntrada(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getFin().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getInicio().equals(vertice)) ++res;
		}
		return res;
	}

	public List<T> recorridoAnchura(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		//estructuras auxiliares
		Queue<Vertice<T>> pendientes = new LinkedList<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pendientes.add(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<T> actual = pendientes.poll();
			List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}		
		System.out.println(resultado);
		return resultado;
 	}
	
	public List<T> recorridoProfundidad(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		//estructuras auxiliares
		Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pendientes.push(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<T> actual = pendientes.pop();
			List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}		
		System.out.println(resultado);
		return resultado;
 	}
 	
	public List<T> recorridoTopologico(){
		List<T> resultado = new ArrayList<T>();
		Map<Vertice<T>,Integer> gradosVertice = new HashMap<Vertice<T>,Integer>();
		for(Vertice<T> vert : this.vertices){
			gradosVertice.put(vert, this.gradoEntrada(vert));
		}
		while(!gradosVertice.isEmpty()){
                    List<Vertice<T>> nodosSinEntradas = gradosVertice.entrySet().stream()
                    .filter(map -> map.getValue()==0)
                    .map(map -> map.getKey())
                    .collect(Collectors.toList());
			
			
                    for(Vertice<T> v : nodosSinEntradas){
			resultado.add(v.getValor());
			gradosVertice.remove(v);
			for(Vertice<T> ady: this.getAdyacentes(v)){
                            gradosVertice.put(ady,gradosVertice.get(ady)-1);
			}
                    }
		}
		
		System.out.println(resultado);
		return resultado;
 	}
        
        private boolean esAdyacente(Vertice<T> v1,Vertice<T> v2){
            List<Vertice<T>> ady = this.getAdyacentes(v1);
            for(Vertice<T> unAdy : ady){
                if(unAdy.equals(v2)) return true;
            }
            return false;
        }
        
        private boolean esAdyacente8(Vertice<T> v1,Vertice<T> v2){
            return this.getAdyacentes(v1).stream().anyMatch((unAdy) -> (unAdy.equals(v2)));
        }

        
        public boolean existeCaminoIter(Vertice<T> v1,Vertice<T> v2){
            if(esAdyacente8(v1, v2)) return true;
            Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
            HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
            pendientes.addAll(this.getAdyacentes(v1));
            marcados.addAll(this.getAdyacentes(v1));
            
            while(!pendientes.isEmpty()){
                Vertice<T> actual = pendientes.pop();
                if(esAdyacente8(actual, v2)) {
                    System.out.println("es adyacente marcados: "+v1.getValor()+" --> "+v2.getValor());
                    System.out.println(marcados);
                    return true;
                }                
                List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
                for(Vertice<T> v : adyacentes){
                    if(!marcados.contains(v)){ 
                        pendientes.push(v);
                        marcados.add(v);
                    }
		}
            }
            System.out.println("marcados: "+v1.getValor()+" --> "+v2.getValor());
            System.out.println(marcados);
            return false;
        }
        
         public List<String> caminos(Vertice<T> v1,Vertice<T> v2){
            List<String> caminos = new ArrayList<String>();
            List<Vertice<T>> caminoActual = new ArrayList<Vertice<T>>();

            Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
            HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();            
            pendientes.add(v1);
            marcados.add(v1);
            
            while(!pendientes.isEmpty()){
                Vertice<T> actual = pendientes.peek();
                caminoActual.add(actual);
                if(esAdyacente8(actual, v2)) {
                    caminoActual.add(v2);
                    caminos.add(caminoActual.toString());
                    caminoActual.remove(v2);
                    caminoActual.remove(actual);
                    marcados.add(v2);
                }                
                List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
                for(Vertice<T> v : adyacentes){
                    if(!marcados.contains(v)){ 
                        pendientes.push(v);
                        marcados.add(v);
                    }else{
                        caminoActual.remove(v);
                        pendientes.remove(v);
                    }
		}
                
            }
            System.out.println(caminos);
            return caminos;
        }
        
        public boolean existeCiclo(){            
            /*if(esAdyacente8(v1, v2)) return true;
            List<Vertice<T>> adyacentes = this.getAdyacentes(v1);
            for(Vertice<T> v : adyacentes){
                return existeCaminoRec(v, v2);
            }*/
            return false;
        }
        
        public boolean existeCaminoRec(Vertice<T> v1,Vertice<T> v2){
            if(esAdyacente8(v1, v2)) return true;
            else return existeCaminoRec(v1, v2,new HashSet<Vertice<T>>());
        }

        private boolean existeCaminoRec(Vertice<T> v1,Vertice<T> v2,Set<Vertice<T>> visitados){            
            if(esAdyacente8(v1, v2)) return true;
            List<Vertice<T>> adyacentes = this.getAdyacentes(v1);
            for(Vertice<T> v : adyacentes){
                if(!visitados.contains(v)) {
                    visitados.add(v);
                    if(existeCaminoRec(v, v2,visitados))return true;
                }
            }
            return false;
        }
        
        public boolean existeCaminoIter(Vertice<T> v1,Vertice<T> v2,Integer n){
            if(esAdyacente8(v1, v2) && n==1) return true;
            Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
            HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
            pendientes.addAll(this.getAdyacentes(v1));
            marcados.addAll(this.getAdyacentes(v1));
            Integer saltos = 1;
            while(!pendientes.isEmpty() && saltos<=n){
                Vertice<T> actual = pendientes.pop();
                if(esAdyacente8(actual, v2)) {
                    System.out.println("es adyacente marcados: "+v1.getValor()+" --> "+v2.getValor());
                    System.out.println(marcados);
                    return true;
                }                
                List<Vertice<T>> adyacentes = this.getAdyacentes(actual);
                for(Vertice<T> v : adyacentes){
                    if(!marcados.contains(v)){ 
                        pendientes.push(v);
                        marcados.add(v);
                    }
		}
                saltos++;
            }
            System.out.println("marcados: "+v1.getValor()+" --> "+v2.getValor());
            System.out.println(marcados);
            return false;
        }
        
        public boolean existeCaminoRec(Vertice<T> v1,Vertice<T> v2,Integer n){
            return existeCaminoRec(v1, v2,n,new HashSet<Vertice<T>>());
        }
        
        public boolean existeCaminoRec(Vertice<T> v1,Vertice<T> v2,Integer n,Set<Vertice<T>> visitados){
            if(n==0) return false;
            if(esAdyacente8(v1, v2)&& n ==1) return true;
            List<Vertice<T>> adyacentes = this.getAdyacentes(v1);
            for(Vertice<T> v : adyacentes){
                if(!visitados.contains(v)) {
                    visitados.add(v);
                    if(existeCaminoRec(v, v2,n-1,visitados))return true;
                }
            }
            return false;
        }
        
        /**
         * retorna un valor entero, 
         * que representa la distancia más grande del 
         * menor camino que hay entre “unVertice” 
         * y cualquier otro vertice del grafo.
         * @param v1
         * @return 
         */
        public Integer excentricidad(Vertice<T> v1){
            return 0;
        }
        

}
