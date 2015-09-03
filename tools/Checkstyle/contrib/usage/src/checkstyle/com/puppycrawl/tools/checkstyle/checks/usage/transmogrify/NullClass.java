
// Transmogrify License
// 
// Copyright (c) 2001, ThoughtWorks, Inc.
// All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
// - Redistributions of source code must retain the above copyright notice,
//   this list of conditions and the following disclaimer.
// - Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
// Neither the name of the ThoughtWorks, Inc. nor the names of its
// contributors may be used to endorse or promote products derived from this
// software without specific prior written permission.
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
// TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
// PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
// CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
// EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
// PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
// OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package com.puppycrawl.tools.checkstyle.checks.usage.transmogrify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NullClass implements IClass {

  @Override
public Iterator getReferences() {
    return new ArrayList().iterator();
  }

  @Override
public int getNumReferences() {
    return 0;
  }

  @Override
public void addReference(Reference ref) {}

  @Override
public String getName() {
    return "null";
  }

  @Override
public String getQualifiedName() {
    return getName();
  }

  @Override
public boolean isSourced() {
    return false;
  }

  @Override
public IClass getSuperclass() {
    return null;
  }

  @Override
public IClass[] getInterfaces() {
    return new IClass[0];
  }

  @Override
public IClass[] getInnerClasses() {
    return new IClass[0];
  }

  @Override
public List getSubclasses() {
    return new ArrayList();
  }

  @Override
public IClass getClassDefinition(String name) {
    return null;
  }

  @Override
public IMethod getMethodDefinition(String name,
                                     ISignature signature) {
    return null;
  }

  @Override
public IVariable getVariableDefinition(String name) {
    return null;
  }

  @Override
public void addSubclass(ClassDef subclass) {}
  @Override
public void addImplementor(ClassDef implementor) {}

  @Override
public List getImplementors() {
    return new ArrayList();
  }

  @Override
public boolean isCompatibleWith(IClass type) {
    return true;
  }

  @Override
public boolean isPrimitive() {
    return false;
  }

}




