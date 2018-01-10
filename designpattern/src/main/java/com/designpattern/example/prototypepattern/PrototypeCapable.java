package com.designpattern.example.prototypepattern;

public interface PrototypeCapable extends Cloneable {

	PrototypeCapable clone() throws CloneNotSupportedException;
}
