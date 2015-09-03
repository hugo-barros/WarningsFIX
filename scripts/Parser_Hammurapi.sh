#####################################################
#####    inserir dados da Hammurapi no BD        #####  
#####################################################
#echo inserindo dados programa $2 da ferramenta Hammurapi no BD

JARS_DIR=/home/vr/Dropbox/WarningsFix/parser/Hammurapi/lib
DIR_TMP=/home/vr/Dropbox/WarningsFix/tmp					   
cd $JARS_DIR

ls *.jar > $DIR_TMP/libs-jar-hammurapi.txt

JARS="";

for JAR in `cat $DIR_TMP/libs-jar-hammurapi.txt` 
do JARS=$JARS_DIR/$JAR:$JARS
done

cd /home/vr/Dropbox/WarningsFix/parser/Hammurapi/bin
CLASSPATH=$CLASSPATH:$JARS
java -cp $CLASSPATH br.ufg.inf.es.vv.hamurapi.htmlparser.MainHtmlParser $1  > /dev/null >&2

#####################################################
#####           Terminando                      #####  
#####################################################
