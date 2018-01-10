package com.designpattern.example.builderfactory.factorypattern;

import java.io.IOException;
import java.util.Properties;

public interface IFileReader {

	Properties getProperty(String filename) throws IOException;
}
