#####################################################
#####    inserir dados da Hammurapi no BD        #####  
#####################################################
JARS_DIR=~/workspace/WarningsFIX/parser/Hammurapi2/lib					   
cd $JARS_DIR

JARS="";

for JAR in $(ls *.jar)
do JARS=$JARS_DIR/$JAR:$JARS
done

cd ~/workspace/WarningsFIX/parser/Hammurapi2/bin

CLASSPATH=$CLASSPATH:$JARS
java -cp $CLASSPATH br.ufg.inf.es.vv.hamurapi.htmlparser.Parser $1 $2 $3

#####################################################
#####           Terminando                      #####  
#####################################################
