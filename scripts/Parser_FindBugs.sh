#####################################################
#####    inserir dados da FindBugs no BD        #####  
#####################################################
#echo inserindo dados programa $2 da ferramenta FindBugs no BD
JARS_DIR=~/workspace/WarningsFIX/parser/FindBugs/lib 
					   
cd $JARS_DIR

JARS="";

for JAR in $(ls *.jar)
do JARS=$JARS_DIR/$JAR:$JARS
done

cd ~/workspace/WarningsFIX/parser/FindBugs/bin
CLASSPATH=$CLASSPATH:$JARS
java -cp $CLASSPATH  br.ufg.inf.findbugsparser.CadastraDadosPrograma $1 $2 $3 $4 $5 $6 $7  

#####################################################
#####           Terminando                      #####  
#####################################################
