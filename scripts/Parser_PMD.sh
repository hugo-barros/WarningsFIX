#####################################################
#####    inserir dados do PMD no BD        #####  
#####################################################
echo inserindo dados programa $2 sobre a regra $4 da ferramenta PMD no BD

JARS_DIR=/home/vr/Dropbox/WarningsFix/parser/PMD/lib 
DIR_TMP=/home/vr/Dropbox/WarningsFix/tmp					   
cd $JARS_DIR

ls *.jar >& $DIR_TMP/libs-jar-pmd.txt

JARS="";

for JAR in `cat $DIR_TMP/libs-jar-pmd.txt` 
do JARS=$JARS_DIR/$JAR:$JARS
done


cd /home/vr/Dropbox/WarningsFix/parser/PMD/bin
CLASSPATH=$CLASSPATH:$JARS
java -cp $CLASSPATH  parse.main $1 $3 $2


#####################################################
#####           Terminando                      #####  
#####################################################
