nl-toolkit
==========

This is a helper library for my projects, containing some misc / convenience classes I usually use in my stuff.

Getting Started
---------------

You can add the project with maven or gradle via adding the appropiate dependence.

```groovy
compile 'io.nlopez.toolkit:library:1.0.1'
```

Adapters
--------

### SingleAdapter

Adapter that leverages all the work that needs to be done for a list with only one type of cells in display.

Example (taken from Sample app):

```java
SingleAdapter<TextAndImageItem, TextAndImageItemView> adapter = Adapters.newSingleAdapter(TextAndImageItemView.class, items);
listView.setAdapter(adapter);
```

### AASingleAdapter

Same as SingleAdapter, but for Android Annotations annotated classes (with @EViewGroup).

### MultiAdapter

The multi-view type alternative to SingleAdapter. We have to provide it with a map of Object classes to its View classes.

Example (taken from Sample app):

```java
Map<Class, Class<? extends BindableLayout>> mapping = new Mapper()
  .add(TextAndImageItem.class, TextAndImageItemView.class)
  .add(TextImageAndButtonItem.class, TextImageAndButtonItemView.class)
  .asMap();

MultiAdapter adapter = Adapters.newMultiAdapter(mapping, items);
listView.setAdapter(adapter);
```

### AAMultiAdapter

Same as MultiAdapter, but for Android Annotations annotated classes (with @EViewGroup).

### RecyclerSingleAdapter, RecyclerMultiAdapter, AARecyclerSingleAdapter, AARecyclerMultiAdapter

They have exactly the same parameters as their counterparts but they work with RecyclerView instead of an AbsListView inherited class.

Intents
-------

There are a couple of typical intent creators in the Intents class, such as:

* Share text
* Share binary
* Open URL
* Send email
* Open dialer with phone number
* Open navigator to coordinates
* Take picture with the camera
* Open gallery

Miscellaneous
-------------

There is some more stuff bundled in here:

* DeviceIdentifier class, in where you could either use the typical ANDROID_ID approach or the per-installation UUID generation.
* ThreadHelper, with crash enforcers for background thread / main thread so we can build upon fail fast strategies.
* MenuFragmentEntry, the typical model for using as row in a left drawer menu ListView.
* ActivityTransitions, for being able to easily use custom animations between activities. It comes with a default slide-left animation.

Future
------

If this little library begins to grow, I will most definitely break it up into smaller packages.

License
-------

The MIT License (MIT)

Copyright (c) 2014-2015 Nacho Lopez

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
