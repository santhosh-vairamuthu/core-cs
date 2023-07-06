#include <stdio.h>

int main(int argc, char *argv[]) {
	int table=13;
	printf("<html> \n \
	<body bgcolor=\"red\"> \n \
	\n \
	<h2>Basic HTML Table</h2>\n ");
	printf("	<tr>\n\
  <th>Multiplicant</th>\n\
  <th>Multiplier</th>\n \
  <th>Result</th>\n\
	</tr>\n");
	printf("	<table style=\"width:100%%\"> \n");
	for(int i=0; i<100; i++){
  int result = i * 13;
  printf("	<tr>\n\
  <td>%d</td>\n\
  <td>%d</td>\n\
  <td>%d</td>\n\
	</tr>\n",i, table, result);
	}
	printf("\n</table>\n\
	\n\
</body> \n\
</html>\n");
}