nl-toolkit
==========

This is a helper library for my projects. It is not ready for production (for the time being). It is also not documented at this time. Just ignore it.

Getting Started
---------------

You can add the project with maven or gradle via adding the appropiate dependence.

```groovy
compile 'io.nlopez.toolkit:library:1.+'
```

(Still not on Maven Central, as I haven't developed what I want to do yet XD)

Adapters
--------

### SingleViewTypeAdapter

Adapter that leverages all the work that needs to be done for a list with only one type of cells in display.

Example (taken from Sample app):

```java
SingleViewTypeAdapter<TextAndImageItem, TextAndImageItemView> adapter = new SingleViewTypeAdapter<TextAndImageItem, TextAndImageItemView>(TextAndImageItemView.class, items);
listView.setAdapter(adapter);
```

### AASingleViewTypeAdapter

Same as SingleViewTypeAdapter, but for Android Annotations annotated classes (with @EViewGroup).

License
-------

The MIT License (MIT)

Copyright (c) 2014 Nacho Lopez

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.