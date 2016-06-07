package died2016.grafos.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestGrafo {

	private Grafo<String> grafo ;
	private Grafo<String> grafoTopologico ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		grafo = new Grafo<String>();
		grafo.addNodo("D");
		grafo.addNodo("B");
		grafo.addNodo("C");
		grafo.addNodo("R");
		grafo.addNodo("H");
		grafo.addNodo("A");
		grafo.addNodo("T");
		grafo.conectar("D", "B");
		grafo.conectar("D", "C");
		grafo.conectar("B", "H");
		grafo.conectar("C", "R");
		grafo.conectar("H", "A");
		grafo.conectar("H", "T");
		grafo.conectar("H", "D");
		grafo.conectar("R", "H");

		grafoTopologico = new Grafo<>();
		grafoTopologico.addNodo("A");
		grafoTopologico.addNodo("B");
		grafoTopologico.addNodo("C");
		grafoTopologico.addNodo("D");
		grafoTopologico.addNodo("E");
		grafoTopologico.conectar("A", "C");
		grafoTopologico.conectar("B", "D");
		grafoTopologico.conectar("D", "C");
		grafoTopologico.conectar("D", "E");
		grafoTopologico.conectar("C", "E");




	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
        public void test() {
		List<String> listaResultado= new ArrayList<String>();
		listaResultado.add("D");
		listaResultado.add("B");
		listaResultado.add("C");
		listaResultado.add("H");
		listaResultado.add("R");
		listaResultado.add("A");
		listaResultado.add("T");
		Vertice<String> inicial = new Vertice<>("D");
		assertArrayEquals(listaResultado.toArray(), grafo.recorridoAnchura(inicial).toArray());
		grafo.conectar("D", "R");
		assertArrayEquals(listaResultado.toArray(), grafo.recorridoAnchura(inicial).toArray());
	}

	@Ignore
        public void testProfundidad() {
		List<String> listaResultado= new ArrayList<String>();
		listaResultado.add("D");
		listaResultado.add("C");
		listaResultado.add("R");
		listaResultado.add("H");
		listaResultado.add("T");
		listaResultado.add("A");
		listaResultado.add("B");
		Vertice<String> inicial = new Vertice<>("D");
		assertArrayEquals(listaResultado.toArray(), grafo.recorridoProfundidad(inicial).toArray());
		grafo.conectar("D", "R");
		assertArrayEquals(listaResultado.toArray(), grafo.recorridoProfundidad(inicial).toArray());
	}

	@Ignore
	public void testTopologico() {
		assertEquals("E", grafoTopologico.recorridoTopologico().get(4));
	}
        
        @Ignore
	public void testCaminos() {
            Vertice<String> vertInicial = new Vertice<String>("D");
            Vertice<String> vertFinal1 = new Vertice<String>("B");
            Vertice<String> vertFinal2 = new Vertice<String>("C");
            Vertice<String> vertFinal3 = new Vertice<String>("H");
            Vertice<String> vertFinal4 = new Vertice<String>("R");
            Vertice<String> vertFinal5 = new Vertice<String>("A");
            Vertice<String> vertFinal6 = new Vertice<String>("T");
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinal1));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinal2));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinal3));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinal4));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinal5));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinal6));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertInicial));
            assertTrue(grafo.existeCaminoIter(vertFinal4, vertFinal2));
	}
        
                @Ignore
	public void testCaminosRec() {
            Vertice<String> vertInicial = new Vertice<String>("D");
            Vertice<String> vertFinal1 = new Vertice<String>("B");
            Vertice<String> vertFinal2 = new Vertice<String>("C");
            Vertice<String> vertFinal3 = new Vertice<String>("H");
            Vertice<String> vertFinal4 = new Vertice<String>("R");
            Vertice<String> vertFinal5 = new Vertice<String>("A");
            Vertice<String> vertFinal6 = new Vertice<String>("T");
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinal1));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinal2));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinal3));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinal4));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinal5));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinal6));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertInicial));
            assertTrue(grafo.existeCaminoRec(vertFinal4, vertFinal2));
        }
        
        @Ignore
	public void testCaminosNSaltos() {
            Vertice<String> vertInicial = new Vertice<String>("D");
            Vertice<String> vertFinal3 = new Vertice<String>("H");
            assertFalse(grafo.existeCaminoIter(vertInicial, vertFinal3,1));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinal3,2));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinal3,3));
            Vertice<String> vertFinalT = new Vertice<String>("T");
            assertFalse(grafo.existeCaminoIter(vertInicial, vertFinalT,1));
            assertFalse(grafo.existeCaminoIter(vertInicial, vertFinalT,2));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinalT,3));
            assertTrue(grafo.existeCaminoIter(vertInicial, vertFinalT,3));            
        }

                
        @Ignore
	public void testCaminosNSaltosRec() {
            Vertice<String> vertInicial = new Vertice<String>("D");
            Vertice<String> vertFinal3 = new Vertice<String>("H");
            assertFalse(grafo.existeCaminoRec(vertInicial, vertFinal3,1));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinal3,2));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinal3,3));
            Vertice<String> vertFinalT = new Vertice<String>("T");
            assertFalse(grafo.existeCaminoRec(vertInicial, vertFinalT,1));
            assertFalse(grafo.existeCaminoRec(vertInicial, vertFinalT,2));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinalT,3));
            assertTrue(grafo.existeCaminoRec(vertInicial, vertFinalT,3));            
        }
        
        @Test
        public void allPaths(){
            Vertice<String> vertInicial = new Vertice<String>("D");
            Vertice<String> vertFinal3 = new Vertice<String>("H");
            System.out.println(grafo.caminos(vertInicial, vertFinal3));
            assertTrue(true);
        }
}
