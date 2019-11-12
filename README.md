Enunciado do Trabalho Final

 

 

A corrida para fazer a declaração de Imposto de Renda do período de 2011 já passou. Agora começa a corrida para preparar o software que será usado no período de 2012. Como estagiário de sistemas na Receita Estadual, você deve, a partir das especificações a seguir, implementar um aplicativo para fazer a simulação de declarações de IR para pessoa física, utilizando interface gráfica e banco de dados. Utilize todos os conteúdos vistos no decorrer da disciplina de LPG-II para implementar este aplicativo. Todas as especificações aqui descritas devem ser seguidas, a fim de que o aplicativo seja o mais profissional, consistente, e de melhor interface com o usuário quanto possível.

 

1- Especificação estrutural do sistema:

 

1.1- A camada de apresentação deve estar contida no pacote apresentacao. Neste pacote, devem estar a classe do método main e as classes necessárias para o funcionamento de uma GUI (interface gráfica). A interação do usuário com o programa deve ser feita inteiramente pela interface gráfica, e a mesma deve estar organizada e ser bonita e intuitiva. Procure sempre que possível utilizar objetos de lista ou tabela para apresentar dados (ao invés de JLabels) e também procure evitar um programa com muitas janelas (podendo utilizar um JTabbedPane para organizar múltiplos painéis). A camada de apresentação deve permitir ao usuário acesso à todas as funcionalidades do programa, e apresentar seus resultados.

 

1.2- A camada de lógica deve estar contida no pacote negocio. Neste pacote, deve haver uma ou mais classes que recebem as requisições e dados de entrada do usuário e que efetivamente implementam as funcionalidades do sistema (que serão apresentadas na sequência). Será também nesta(s) classe(s) que o programa irá criar e manipular objetos dos tipos contidos na camada de dados, e que haverá também a comunicação com a camada de persistência. As funcionalidades do sistema são apresentadas na seção 2.

1.3- A camada de dados deve estar contida no pacote dados. Neste pacote se encontram as classes que serão persistidas no banco de dados. O diagrama UML apresentado a seguir contém o modelo destas classes.

1.4- A camada de persistência deve estar contida no pacote persistencia. Neste pacote, devem estar a classe de conexão com o BD, que deve ser implementada utilizando o padrão de projeto Singleton para se ter uma única instância de conexão, e as classes de acesso a dados, implementadas utilizando o padrão de projeto DAO, uma para cada classe contida no pacote de dados, que vão se comunicar com o BD e manipular os objetos de transferência contidos na camada de dados.

2- Especificação das funcionalidades do sistema:

2.1- As funcionalidades de inclusão que devem ser implementadas são: 1) cadastrar contribuinte; 2) cadastrar dependente (adiciona um dependente a um contribuinte, não podendo haver dependentes sem um contribuinte associado); 3) incluir bem (adiciona um bem a um contribuinte); 4) validar nota fiscal (adiciona como despesa do contribuinte); 5) validar contracheque (adiciona como receita do contribuinte) e 6) cadastrar pessoa jurídica (adiciona uma pessoa jurídica ao banco de dados, sendo que toda nota fiscal ou contracheque deve conter um CNPJ de uma pessoa jurídica cadastrada para ser adicionado ao contribuinte).

2.2- As funcionalidades de consulta que devem ser implementadas são: 1) consultar contribuinte (deve mostrar os atributos básicos de um contribuinte cadastrado, seus dependentes e seus bens); 2) consultar receitas (deve mostrar todos os contracheques de um contribuinte e a receita total); 3) consultar despesas (deve mostrar todos as despesas de um contribuinte e a despesa total); e 4) consultar pessoa jurídica (deve mostrar os atributos básicos de uma pessoa jurídica e todas as notas fiscais e todos os contracheques associados a ela).

2.3- As funcionalidades de atualização que devem ser implementadas são: 1) alterar contribuinte (deve permitir alterar os atributos básicos de um contribuinte cadastrado, menos o CPF); 2) alterar dependente (deve permitir alterar todos os atributos de um dependente, menos o CPF); e 3) alterar pessoa jurídica (deve permitir alterar todos os atributos de uma pessoa jurídica, menos o CNPJ). Bens, notas fiscais e contracheques não podem ser alterados uma vez que sejam inseridos.

2.4- As funcionalidades de remoção que devem ser implementadas são: 1) remover dependente; 2) remover bem; 3) remover nota fiscal; 4) remover contracheque; e 5) remover pessoa jurídica (deve remover a pessoa jurídica e todas as notas fiscais e contracheques que fazem referência a ela). Contribuintes não podem ser removidos uma vez que sejam inseridos.

2.5- Permita também uma 1) listagem de todos os contribuintes e seus CPFs; e outra 2) listagem para todas as pessoas jurídicas e seus CNPJs. Isso facilita tanto o uso quanto o teste do aplicativo e do funcionamento do BD.

Nota: Lembre-se de tentar aplicar ao máximo todos os conteúdos vistos em aula. Utilize os conhecimentos obtidos em sala sobre classes e objetos, encapsulamento, padrões de projeto, interface gráfica, coleções e exceções sempre que for conveniente. Modele as tabelas do BD no papel antes de fazer a implementação. Consulte os materiais complementares na página do professor se for preciso, e tire dúvidas com o monitor quando houver a necessidade e não se esqueça de capturar e tratar todas as exceções que puderem ocorrer!
