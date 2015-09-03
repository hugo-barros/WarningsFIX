#####################################################
#####    inserir dados do ESCJAVA no BD        #####  
#####################################################
#echo inserindo dados programa $3 e classe $2 da ferramenta ESCJava no BD

JARS_DIR=~/workspace/WarningsFIX/parser/ESCJava/lib 
DIR_TMP=~/workspace/WarningsFIX/tmp					   
cd $JARS_DIR



JARS="";

for JAR in $(ls *.jar) 
do JARS=$JARS_DIR/$JAR:$JARS
done


cd ~/workspace/WarningsFIX/parser/ESCJava/bin
CLASSPATH=$CLASSPATH:$JARS
java -cp $CLASSPATH  br.ufg.inf.vev.Parser $1 $2 $3 
#####################################################
#####           Terminando                      #####  
#####################################################
