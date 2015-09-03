export JAVA_HOME==~/workspace/WarningsFIX/tools/jdk1.7.0
export PATH=$JAVA_HOME/bin:$PATH

#####################################################
#####    inserir dados da Checkstyle no BD        #####  
#####################################################
#echo inserindo dados programa $2 da ferramenta Checkstyle no BD

JARS_DIR=~/workspace/WarningsFIX/parser/Checkstyle2/lib 
DIR_TMP=~/workspace/WarningsFIX/tmp					   
cd $JARS_DIR

JARS="";

for JAR in $(ls *.jar) 
do JARS=$JARS:$JARS_DIR/$JAR
done

cd ~/workspace/WarningsFIX/parser/Checkstyle2/bin
CLASSPATH=$CLASSPATH:$JARS
XML=~/workspace/WarningsFIX/parser/Checkstyle2/src/main/META-INF/persistence.xml
CLASSPATH=$CLASSPATH:$XML

java -cp $CLASSPATH br.inf.ufg.es.vv.checkstyle.parser.Main $1 $2 $3 

#####################################################
#####           Terminando                      #####  
#####################################################
