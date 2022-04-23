# We need target directory for compilation
mkdir -p target

# '-d' define *.class store folder - './target/'
# 'src/java/edu/school21/printer/*/*.java' - is path to source *.java files
javac -d ./target/ src/java/edu/school21/printer/*/*.java

# '-cp ./target' - path where 'java' command start search of executing class
# 'edu.school21.printer.app.Program' - execute command
# 'src/it.bmp . 0' -command line arguments
java -cp ./target edu.school21.printer.app.Program src/it.bmp . 0