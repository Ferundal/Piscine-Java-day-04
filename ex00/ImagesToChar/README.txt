# We need target directory for compilation
mkdir target

# '-d' define *.class store folder - './target/'
# 'src/java/edu/school21/printer/*/*.java' - is path to source *.java files
javac -d ./target/ src/java/edu/school21/printer/*/*.java

#
java -cp ./target edu.school21.printer.app.Program it.bmp