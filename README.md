# Hotei

My name is [Hotei](https://en.wikipedia.org/wiki/Seven_Lucky_Gods#Hotei).  I happily and declaratively solve Sudoku using [core.logic](https://github.com/clojure/core.logic).  Right now I only solve 9x9 boards but one day I may solve more.

## Usage

```clojure
(require '[hotei.core :as h]
         '[hotei.utils :as u])

(def board '[_ _ _ _ _ _ _ _ 2
             _ _ _ _ _ _ 9 4 _
             _ _ 3 _ _ _ _ _ 5
             _ 9 2 3 _ 5 _ 7 4
             8 4 _ _ _ _ _ _ _
             _ 6 7 _ 9 8 _ _ _
             _ _ _ 7 _ 6 _ _ _
             _ _ _ 9 _ _ _ 2 _
             4 _ 8 5 _ _ 3 6 _])

(u/pprint (h/solve-sudoku board))
```

This will print:

```clojure
6 8 4 1 5 9 7 3 2
7 5 1 8 3 2 9 4 6
9 2 3 6 7 4 1 8 5
1 9 2 3 6 5 8 7 4
8 4 5 2 1 7 6 9 3
3 6 7 4 9 8 2 5 1
2 3 9 7 4 6 5 1 8
5 1 6 9 8 3 4 2 7
4 7 8 5 2 1 3 6 9
```

## License

Copyright © 2020 DreGre

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
