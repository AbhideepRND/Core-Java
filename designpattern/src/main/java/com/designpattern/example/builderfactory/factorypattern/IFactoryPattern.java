package com.designpattern.example.builderfactory.factorypattern;

import com.designpattern.example.builderfactory.FileType;

public interface IFactoryPattern {

	IFileReader getFileProp(String filename,FileType type);
}
