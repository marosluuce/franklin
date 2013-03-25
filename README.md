Franklin
========

Franklin is a multi-threaded Java HTTP Server. It serves defined routes and files from a designated folder.

Ant Commands
--------------
``bash
$ ant           # Compile, run tests, and build jar file.
$ ant test      # Compile and run tests.
$ ant compile   # Compile.
$ ant clean     # Remove compiled classes.
``

Run Command
-------------
``bash
$ java -jar <path-to-jar>/franklin.jar -p <port> -d <directory to serve from>

# Example
$ java -jar franklin.jar -p 5000 -d public
``
Then navigate to `http://localhost:5000/` or `http://<ip-address>:5000/`.

Defined Routes
--------------
- /redirect => redirects to /
- /parameters?<querystring> => displays contents of querystring on page
- /form => GET displays stored contents, POST and PUT update contents

Unsupported Files
---------------
- Video files (byte range requests currently not supported)
