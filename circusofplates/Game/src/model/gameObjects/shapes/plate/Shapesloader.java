package model.gameObjects.shapes.plate;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import model.gameObjects.shapes.ImageObject;

public class Shapesloader {
	private static Shapesloader shapesloader;
	private static Map<String, Class<? extends ImageObject>> classes ;
	private Shapesloader() {
		classes = new HashMap<>();
		load();
	}
	public static Shapesloader getInstance() {
		if(shapesloader ==  null) {
			shapesloader = new Shapesloader();
		}
		return shapesloader;
	}
	public void load() {
		JarFile file;
		try {//PlateClasses.jar
			//C:/Users/SHIKO/git/circusofplates/Game/
			file = new JarFile("resources/PlateClasses.jar");
			URL[] urls = { new URL("jar:file:" + "resources/PlateClasses.jar" + "!/") };
			ClassLoader classLoad = URLClassLoader.newInstance(urls);
			classLoad = new URLClassLoader(urls);
			Enumeration<JarEntry> enumeration = file.entries();
			while (enumeration.hasMoreElements()) {
				JarEntry jarEntry = enumeration.nextElement();
				System.out.println(jarEntry.getName());
				if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")) {
					continue;
				}
				String classname = jarEntry.getName().substring(0, jarEntry.getName().length() - 6);
				classname = classname.replace('/', '.');
				System.out.println(classname);
				Class<?extends ImageObject> c = (Class<? extends ImageObject>) classLoad.loadClass(classname);
				classes.put(c.getName(),c);
				
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public Class<? extends ImageObject> load(String string) {
		return classes.get(string);
	}
	public Map<String, Class<? extends ImageObject>> loadAllclasses() {
		return classes;
	}
}
