export JAVA_HOME==~/workspace/WarningsFIX/tools/jdk1.7.0
export PATH=$JAVA_HOME/bin:$PATH

#####################################################
#####    inserir dados da PMD no BD        #####  
#####################################################
#echo inserindo dados programa $2 sobre a regra $4 da ferramenta PMD no BD

JARS_DIR=~/workspace/WarningsFIX/parser/PMD2/lib 				   
cd $JARS_DIR

 
JARS="";

for JAR in $(ls *.jar)
do JARS=$JARS:$JARS_DIR/$JAR
done
 
cd ~/workspace/WarningsFIX/parser/PMD2/bin
CLASSPATH=$CLASSPATH:$JARS
XML=~/workspace/WarningsFIX/parser/PMD2/src/main/META-INF/persistence.xml
CLASSPATH=$CLASSPATH:$XML

java -cp $CLASSPATH br.inf.ufg.es.vv.pmd.parser.Main $1 $2 $3 

#####################################################
#####           Terminando                      #####  
#####################################################
