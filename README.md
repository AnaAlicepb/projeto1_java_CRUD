<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Cadastro de Clientes">
    <meta name="keywords" content="Java, Swing, Cadastro, Clientes, GUI">
    <meta name="author" content="Ana Alice Rodrigues">
</head>
<body>

<header>
    <h1>Cadastro de Clientes</h1>
    <img src="./CadastroClientes/img/cadastro01.png" alt="Imagem Principal" width="300" height="auto">
    <img src="./CadastroClientes/img/cadastro02.png" alt="Tela de Cadastro" width="300" height="auto">
    <img src="./CadastroClientes/img/cadastro03.png" alt="Tela de Listagem" width="300" height="auto">
    <img src="./CadastroClientes/img/cadastro04.png" alt="Tela de Consulta" width="300" height="auto">
    <img src="./CadastroClientes/img/cadastro05.png" alt="Tela de Remoção" width="300" height="auto">
</header>

<details>
    <summary>Índice</summary>
    <ol>
        <li><a href="#sobre-o-projeto">Sobre o projeto</a></li>
        <li><a href="#parte-tecnica">Parte Técnica</a></li>
        <li><a href="#estrutura-dos-arquivos">Estrutura dos Arquivos</a></li>
        <li><a href="#casos-de-uso">Casos de Uso</a></li>
        <li><a href="#ferramentas">Ferramentas</a></li>
        <li><a href="#contato">Contato</a></li>
    </ol>
</details>

<section id="sobre-o-projeto">
    <h2>Sobre o projeto</h2>
    <p>
        O projeto "Cadastro de Clientes" é uma aplicação desenvolvida em Java que permite gerenciar informações de clientes através de uma interface gráfica amigável. A aplicação possibilita adicionar, listar, consultar e remover clientes de forma eficiente.
    </p>
    <p>
        Proposta de Valor: Este programa é ideal para pequenas empresas ou empreendedores que precisam gerenciar dados de clientes de maneira organizada e acessível.
    </p>
</section>

<section id="parte-tecnica">
    <h2>Parte Técnica</h2>
    <ul>
        <li><strong>Java:</strong> Linguagem de programação utilizada para desenvolver o programa.</li>
        <li><strong>Swing:</strong> Biblioteca gráfica do Java usada para criar a interface gráfica da aplicação.</li>
        <li><strong>GridBagLayout:</strong> Gerenciador de layout utilizado para organizar os componentes na interface de forma flexível e responsiva.</li>
        <li><strong>ArrayList:</strong> Estrutura de dados usada para armazenar a lista de clientes na memória.</li>
        <li><strong>Máscaras de Formatação:</strong> Utilização de máscaras para formatação dos campos de CPF e telefone, garantindo que os dados sejam inseridos no formato correto.</li>
    </ul>
</section>

<section id="estrutura-dos-arquivos">
    <h2>Estrutura dos Arquivos</h2>
    <ul>
        <li><code>Cliente.java</code>: Define a classe Cliente com propriedades como nome, CPF, telefone, endereço, número, complemento, cidade e estado.</li>
        <li><code>ClienteDAO.java</code>: Define a interface com operações para adicionar, obter, listar, atualizar e remover clientes.</li>
        <li><code>ClienteDAOImpl.java</code>: Implementa a interface ClienteDAO utilizando uma lista (ArrayList) para armazenar os dados dos clientes na memória.</li>
        <li><code>Main.java</code>: Contém o método principal que cria a interface gráfica e permite a interação do usuário com o programa.</li>
    </ul>
</section>

<section id="casos-de-uso">
    <h2>Casos de Uso</h2>
    <ul>
        <li>Gerenciamento de dados de clientes para pequenas empresas.</li>
        <li>Organização e categorização de clientes para fácil consulta e manutenção.</li>
    </ul>
</section>

<section id="ferramentas">
    <h2>Ferramentas</h2>
    <ul>
        <li><img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Badge Java"></li>
        <li><img src="https://img.shields.io/badge/Visual_Studio_Code-0078D4?style=for-the-badge&logo=visual-studio-code&logoColor=white" alt="Badge Visual Studio Code"></li>
        <li><img src="https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white" alt="Badge Git"></li>
    </ul>
</section>

<section id="contato">
    <h2>Contato</h2>
    <ul>
        <li><a href="https://linktr.ee/anaeanali5" target="_blank"><img src="https://img.shields.io/badge/Ana_Alice_Rodrigues-blue?style=for-the-badge" alt="Perfil de Ana Alice Rodrigues"></a></li>
    </ul>
</section>

</body>
</html>

