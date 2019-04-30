package com._4mila.backend.service.course.iof2;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class XMLUtility {

	@SuppressWarnings("unchecked")
	public static <T extends Object> T unmarshal(InputStream inputStream, T rootObject, boolean useFilter) throws RuntimeException {
		try {
			XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			reader.setFeature("http://xml.org/sax/features/validation", false);

			// create an input source with a file reader
			// do not use the file name directly, otherwise there are issues with special chars (space, dot, ...)
			// InputSource inputSource = new InputSource(new BOMInputStream(new FileInputStream(fullPathName)));

			/*
			 * if (useFilter) { NamespaceFilter filter = new NamespaceFilter(); filter.setParent(reader); reader = filter; }
			 */

			InputSource inputSource = new InputSource(inputStream);
			SAXSource source = new SAXSource(reader, inputSource);

			JAXBContext context = JAXBContext.newInstance(rootObject.getClass());
			Unmarshaller um = context.createUnmarshaller();
			um.setSchema(null);

			Object unmarshal = um.unmarshal(source);
			return (T) unmarshal;
		} catch (Exception e) {
			throw new RuntimeException("Reading XML file failed", e);
		}
	}

}