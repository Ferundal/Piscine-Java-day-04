# We need target directory for compilation
mkdir -p target

# '-d' define *.class store folder - './target/'
# 'src/java/edu/school21/printer/*/*.java' - is path to source *.java files
# libs include in form '.:<file_1_name>.jar:<file_2_name>.jar'
javac -cp .:./lib/JColor-5.0.0.jar:./lib/jcommander-1.78.jar -d ./target/ src/java/edu/school21/printer/*/*.java

cd target

# Unpack .jar items in target folder
jar xf ./../lib/JColor-5.0.0.jar com ; jar xf ./../lib/jcommander-1.78.jar com

cd ..

# copy resources to jar folder
cp -R src/resources target/.

# 'cmf' - "create archive" "path to manifest.txt" "output file name"
# '-C ./target' - root directory for archive sources is ./target
# '.' everything in this folder will be added
jar cmf src/manifest.txt ./target/images-to-chars-printer.jar -C ./target .

# Change privileges to file to make it executable
chmod u+x ./target/images-to-chars-printer.jar

# '-jar' - run jar archive
# './target/images-to-chars-printer.jar' - archive path
# '. 0' -command line arguments
java -jar ./target/images-to-chars-printer.jar --white=RED --black=GREEN
