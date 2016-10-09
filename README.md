# App-Context

A tiny utility library for Android to get the global app context without overriding the application class. This is especially helpful for Android library projects.

## Download

Download [the latest version](http://search.maven.org/#search|gav|1|g:"net.vrallev.android"%20AND%20a:"app-context") or grab via Gradle:

```groovy
dependencies {
    compile 'net.vrallev.android:app-context:1.0.0'
}
```

## Usage

Use `AppContext.get()` to get the global application context.

```java
public class MyClass {

    public void doSomething() {
        Context context = AppContext.get();
    }
}
```

## License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
