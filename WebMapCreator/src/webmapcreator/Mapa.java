/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webmapcreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fichero: Mapa.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 02-mar-2014
 */
public class Mapa {

    String zoom;
    String[] posicion;
    String titulo;
    String marco[] = {"2", "Black"};
    String grosor;
    String centromapa[];
    String controles[];
    String capas = " ";

    public Mapa() {
    }

    public Mapa(String zoom2, String[] posicion2, String titulo2, String marco2[], String centromapa2[], String controles2[]) {

        zoom = zoom2;
        posicion = posicion2;
        titulo = titulo2;
        marco[0] = marco2[0];
        marco[1] = marco2[1];
        centromapa = centromapa2;
        controles = controles2;

    }

    public void setzoom(String zoom2) {

        zoom = zoom2;
    }

    public void setposicion(String[] posicion2) {

        posicion = posicion2;
    }

    public void settitulo(String titulo2) {

        titulo = titulo2;
    }

    public void setgrosor(String grosor2) {

        marco[0] = grosor2;
    }

    public void setcolor(String color2) {

        marco[1] = color2;
    }

    public void setcentromapa(String centromapa2[]) {

        centromapa = centromapa2;
    }

    public void setcontroles(String controles2[]) {

        controles = controles2;
    }

    public void setcapas(ArrayList<String> capascargadas) {

        String capa;  //Valor de la capa seleccionada
        for (int i = 0; i < capascargadas.size(); i++) {

            /*  if (capascargadas.contains("OpenStreetMap")) {
                
             capas = capas + "var OSMlayer = new OpenLayers.Layer.OSM(); \n"
             + " map.addLayer(OSMlayer); \n \n";          
             }   */


            capa = capascargadas.get(i);

            switch (capa) {

                case "OpenStreetMap":

                    capas = capas + "var OSMlayer = new OpenLayers.Layer.OSM(); \n"
                            + " map.addLayer(OSMlayer); \n \n";

                    break;

                case "OpenStreetMap Toner":


                    capas = capas + "var OSMtoner = new OpenLayers.Layer.XYZ(\n"
                            + "              \"OpenStreetMap (Toner)\",\n"
                            + "              \"http://tile.stamen.com/toner/${z}/${x}/${y}.png\",\n"
                            + "              {\n"
                            + "                sphericalMercator: true,\n"
                            + "                wrapDateLine: true,\n"
                            + "                // TODO: min zoom level 2\n"
                            + "                numZoomLevels: 20,\n"
                            + "              }\n"
                            + "            ); \n"
                            + " map.addLayer(OSMtoner); \n \n";

                    break;

                case "OSM MapQuest":

                    capas = capas + "	var mapquest = new OpenLayers.Layer.OSM(\"OSM MapQuest Open\",                                                   \n"
                            + " [\"http://otile1.mqcdn.com/tiles/1.0.0/osm/${z}/${x}/${y}.png\",\n"
                            + " \"http://otile2.mqcdn.com/tiles/1.0.0/osm/${z}/${x}/${y}.png\",\n"
                            + " \"http://otile3.mqcdn.com/tiles/1.0.0/osm/${z}/${x}/${y}.png\",\n"
                            + " \"http://otile4.mqcdn.com/tiles/1.0.0/osm/${z}/${x}/${y}.png\"]); \n"
                            + " map.addLayer(mapquest); \n \n";

                    break;

                case "OSM Ciclismo":

                    capas = capas + "	var opencyclemap = new OpenLayers.Layer.OSM(\"OSM Ciclismo\",\n"
                            + " [\"http://a.tile.opencyclemap.org/cycle/${z}/${x}/${y}.png\",\n"
                            + "  \"http://b.tile.opencyclemap.org/cycle/${z}/${x}/${y}.png\",\n"
                            + "  \"http://c.tile.opencyclemap.org/cycle/${z}/${x}/${y}.png\"]);	 \n"
                            + " map.addLayer(opencyclemap); \n \n";

                    break;

                case "OSM Transporte":

                    capas = capas + "var transportmap = new OpenLayers.Layer.OSM(\"OSM Transporte\",\n"
                            + " [\"http://a.tile2.opencyclemap.org/transport/${z}/${x}/${y}.png\",\n"
                            + "  \"http://b.tile2.opencyclemap.org/transport/${z}/${x}/${y}.png\",\n"
                            + "  \"http://c.tile2.opencyclemap.org/transport/${z}/${x}/${y}.png\"]); \n"
                            + " map.addLayer(transportmap); \n \n";

                    break;

                case "OSM Humanitarian":

                    capas = capas + "	var humanitarian = new OpenLayers.Layer.OSM(\"Humanitarian Style\",                                                   \n"
                            + " [\"http://a.tile.openstreetmap.fr/hot/${z}/${x}/${y}.png\",\n"
                            + "  \"http://b.tile.openstreetmap.fr/hot/${z}/${x}/${y}.png\",\n"
                            + "   \"http://c.tile.openstreetmap.fr/hot/${z}/${x}/${y}.png\"],\n"
                            + "  {\"tileOptions\": { \"crossOriginKeyword\": null }}); \n"
                            + " map.addLayer(humanitarian); \n \n";

                    break;

                case "OSM Color de agua":

                    capas = capas + "    var watercolour = new OpenLayers.Layer.OSM(\"Stamen watercolour\",                                                   \n"
                            + "  [\"http://tile.stamen.com/watercolor/${z}/${x}/${y}.png\"],\n"
                            + "  {\"tileOptions\": { \"crossOriginKeyword\": null }}); \n"
                            + " map.addLayer(watercolour); \n \n";

                    break;

                case "Google Fisico":

                    capas = capas + "var physical = new OpenLayers.Layer.Google(\n"
                            + " \"Google Physical\",\n"
                            + " {type: google.maps.MapTypeId.TERRAIN}\n"
                            + "  ); \n"
                            + " map.addLayer(physical); \n \n";

                    break;

                case "Google Streets":

                    capas = capas + "var streets = new OpenLayers.Layer.Google(\n"
                            + " \"Google Streets\"\n"
                            + "  ); \n"
                            + " map.addLayer(streets); \n \n";

                    break;

                case "Google Hibrido":

                    capas = capas + "var hybrid = new OpenLayers.Layer.Google(\n"
                            + "  \"Google Hybrid\",\n"
                            + "   {type: google.maps.MapTypeId.HYBRID}\n"
                            + "  ); \n"
                            + " map.addLayer(hybrid); \n \n";

                    break;

                case "Google Satelite":

                    capas = capas + "var satellite = new OpenLayers.Layer.Google(\n"
                            + "  \"Google Satellite\",\n"
                            + "   {type: google.maps.MapTypeId.SATELLITE}\n"
                            + " ); \n"
                            + " map.addLayer(satellite); \n \n";

                    break;

                case "Bing Carreteras":

                    capas = capas + "var Bingroad = new OpenLayers.Layer.Bing({\n" +
"key: apiKey,\n" +
"type: \"Road\",\n" +
"metadataParams: {mapVersion: \"v1\"}\n" +
"}); \n"
                            + " map.addLayer(Bingroad); \n \n";

                    break;

                case "Bing Aereo":

                    capas = capas + "var Bingaerial = new OpenLayers.Layer.Bing({\n" +
"key: apiKey,\n" +
"type: \"Aerial\"\n" +
"}); \n"
                            + " map.addLayer(Bingaerial); \n \n";

                    break;

                case "Bing Aereo con etiquetas":

                    capas = capas + "var Binghybrid = new OpenLayers.Layer.Bing({\n" +
"key: apiKey,\n" +
"type: \"AerialWithLabels\",\n" +
"name: \"Bing Aerial With Labels\"\n" +
"}); \n"
                            + " map.addLayer(Binghybrid); \n \n";

                    break;

                case "OpenGeo Global":

                    capas = capas + "	var basemap = new OpenLayers.Layer.WMS(\n" +
"\"OpenGeo Global Imagery\",\n" +
"\"http://maps.opengeo.org/geowebcache/service/wms\",\n" +
"{layers: \"bluemarble\"}\n" +
"); \n"
                            + " map.addLayer(basemap); \n \n";

                    break;

                case "OpenGeo Azul":

                    capas = capas + "var basemap2 = new OpenLayers.Layer.WMS(\n" +
"\"OpenGeo Blue\",\"http://maps.opengeo.org/geowebcache/service/wms\",\n" +
"{layers: 'blue', format: 'image/png' },\n" +
"{ tileSize: new OpenLayers.Size(256,256)}); \n"
                            + " map.addLayer(basemap2); \n \n";

                    break;

                case "OpenGeo Tiza":

                    capas = capas + "var basemap3 = new OpenLayers.Layer.WMS(\n" +
"\"OpenGeo Tiza\",\"http://maps.opengeo.org/geowebcache/service/wms\",\n" +
"{layers: 'chalk', format: 'image/png' },\n" +
"{ tileSize: new OpenLayers.Size(256,256)}); \n"
                            + " map.addLayer(basemap3); \n \n";

                    break;

                case "OpenGeo Grafito":

                    capas = capas + "var basemap4 = new OpenLayers.Layer.WMS(\n" +
"\"OpenGeo Grafito\",\"http://maps.opengeo.org/geowebcache/service/wms\",\n" +
"{layers: 'graphite', format: 'image/png' },\n" +
"{ tileSize: new OpenLayers.Size(256,256)}); \n"
                            + " map.addLayer(basemap4); \n \n";

                    break;
            }


        };




    }

    public void Obtenerfichero() {


        File folder = new File("..\\Mapas");

        if (!folder.exists()) {

            folder.mkdir();
        }


        File fichero = new File("..\\Mapas\\Mapa.html");



        try {
            FileWriter fw = new FileWriter(fichero);

            fw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                    + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                    + " <head>\n"
                    + " <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
                    + " <title>" + titulo + "</title>\n"
                    + " <style type=\"text/css\">\n"
                    + "  #map {\n"
                    + "position: absolute;\n"
                    + "top: " + posicion[3] + "%;\n"
                    + "left: " + posicion[2] + "%;\n"
                    + "width: " + posicion[0] + "%;\n"
                    + "height: " + posicion[1] + "%;\n"
                    + "border: solid " + marco[0] + "px " + marco[1] + ";\n"
                    + "  }\n"
                    + " </style>\n"
                    + " <script src=\"http://www.openlayers.org/api/OpenLayers.js\"></script>\n"
                    + " <script src=\"http://maps.google.com/maps/api/js?sensor=false\"></script>\n"
                    + " <script type=\"text/javascript\">\n"
                    + "  function init() {\n"
                    + "  \n"
                    + "  //Creamos una variable que contiene las opciones a introducir en el mapa\n"
                    + "  	var options = {\n"
                    + "\n"
                    + "                    projection: new OpenLayers.Projection(\"EPSG:900913\"),\n"
                    + "\n"
                    + "                    displayProjection: new OpenLayers.Projection(\"EPSG:4326\"),\n"
                    + "\n"
                    + "    };\n"
                    + "  \n"
                    + "  //Creamos el mapa\n"
                    + "    var map = new OpenLayers.Map( 'map', options );\n"
                    + "	\n"
                    + "  //Creamos la capa de OpenStreetMaps\n"
                    // API key for http://openlayers.org. Please get your own at
                    // http://bingmapsportal.com/ and use that instead.
                    + " var apiKey = 'AqTGBsziZHIJYYxgivLBf0hVdrAk9mWO5cQcb8Yux8sW5M8c8opEC2lZqKR1ZZXf';"
                    + capas
                    + "	\n"
                    + "  //Ubicamos el centro del mapa y le asignamos el nive de zoom\n"
                    + "    var lonLat = (new OpenLayers.LonLat(" + centromapa[0] + ", " + centromapa[1] + "));"
                    + "    var centro = lonLat.transform(new OpenLayers.Projection(\"EPSG:4326\"), map.getProjectionObject());"
                    + "    map.setCenter(centro," + zoom + ");\n"
                    + "	\n"
                    + "  //Le añadimos una serie de controles a nuestro mapa, en este caso el selector de capas, el indicador de la coordenada del puntero, y la escala\n"
                    + controles[0] + "\n"
                    + controles[1] + "\n"
                    + controles[2] + "\n"
                    + controles[3] + "\n"
                    + controles[4] + "\n"
                    + controles[5] + "\n"
                    + "  }\n"
                    + " </script>\n"
                    + " </head>\n"
                    + " <body onload=\"init()\">\n"
                    + " \n"
                    + "\n"
                    + "  <div id=\"map\">\n"
                    + "  </div>\n"
                    + "  \n"
                    + " </body>\n"
                    + "</html>");
            fw.write("\r\n");

            fw.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
