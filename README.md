# garden-watch

This is a leiningen plugin that just watches for changes to your Garden source files


## Usage


To use this plugin across your projects, put `[garden-watch "0.1.0"]` into the `:plugins` vector of your `:user` profile.

Or if you are on Leiningen 1.x do `lein plugin install garden-watch 0.1.0`.

To install this plugin at a project level, put `[garden-watch "0.1.0"]` into the `:plugins` vector of your project.clj.

You can set this configuration `{:garden-watch {:input-dir "in/" :output-dir "out/"}}` in your project.clj. Then you can just call the plugin like so.

    $ lein garden-watch


Or you can just pass in those parameters directly. This also acts as an override to the configured values.

    $ lein garden-watch :input-dir in/ :output-dir out/


## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
