# GamePortal
All the games from this year's Intermediate Com Sci class into one big repo. 
cd "/Users/adityagarg/intermediate_programming/GamePortal-main"
find src -name "*.java" -print0 | xargs -0 javac -cp "lib/core.jar" -d bin
java -cp "bin:lib/core.jar" GamePortal