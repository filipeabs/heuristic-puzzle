# heuristics-puzzle
Resolução do problema “Quebra-cabeça de oito peças” por meio de algoritmo de busca heurística

Abstract: Our goal in this work is to show how to solve the eight pieces puzzle problem (or sliding tiles puzzle) using search strategy technique of intelligent systems. We divided this work establishing the environment involved and the problem characteristics at first, after we explore how to lead the puzzle to the desired state objective using functional heuristics. Finally we present a solution and the results developed using Java program language.

Resumo: O presente trabalho tem por objetivo apresentar a estratégia de busca de melhor custo para resolução do problema “Quebra-cabeça de oito peças”. Na divisão do trabalho, começamos por estabelecer como desenvolver as características do problema estabelecendo o ambiente. Depois exploramos como aplicar heurísticas funcionais que possam levar o sistema ao estado desejado. E por fim apresentamos o desenvolvimento em linguagem Java para a solução e seus resultados.

Keywords: puzzle; intelligent system design; heuristic search;search problems.
Palavras-chaves: quebra-cabeça de oito peças; sistemas inteligentes; busca heurística; problemas de busca.

 
1. INTRODUÇÃO
O quebra-cabeça com bloco deslizante tem sido aplicado para desenvolvimento de testes com heurísticas de busca baseada em inteligência artificial. O nosso quebra-cabeça consiste em oito blocos quadriculados dispostos em um tabuleiro quadrado 3x3 com uma posição vazia. A ideia é usar o bloco vazio para trocar de posição com algum dos outros blocos adjacentes: de cima, de baixo, do lado direito, do lado esquerdo, respeitando a borda do nosso tabuleiro, e chegar à configuração da figura 1.

 <p align="center">
 <img src="local\resources\images\8puzzleGoal.png"/>
 </p>
<center>Figura 1 - Quebra-cabeça de 8 peças*</center>
 <br>
Conforme observamos na figura 1 temos dois extremos a serem alcançados: inferior direito e superior esquerdo. Se movermos a peça “8” até a sua posição no vértice inferior direito, alcançamos sua meta, e as peças com numeração descendente da direita para esquerda nas colunas, e de baixo para cima nas linhas, estarão de acordo com o objetivo, respeitando as regras de movimentações; e o bloco vazio - representado pelo número 0 (zero) - estará no outro extremo.
Com essa informação, podemos realizar uma matriz onde queremos trabalhar com os custos para movimentações que levem a peça "vazia" para próxima posição de menor custo.
Vejamos como podemos realizar esses movimentos utilizando algoritmo de busca heurística, conforme próximo item sobre estratégia. 
Apenas citando que verificamos que nosso problema é 	observável, uma vez que sabemos de seu estado atual; é discreto, pois sabemos que há um limite para as movimentações; conhecido, pois sabemos qual estado alcançamos em cada ação; determinístico, pois cada ação nos da um resultado.



2. ESTRATÉGIA DE BUSCA
Algoritmos de busca são técnicas de Inteligência Artificial aplicadas a problemas de alta complexidade teórica que não são resolvidos com técnicas de programação convencionais, principalmente as de natureza puramente numérica. A "complexidade" de um problema está diretamente relacionada ao tamanho do seu "Espaço de Busca" correspondente.
Na busca heurística, h(n), o objetivo é levado em conta para determinar qual caminho percorrer e assim escolher um de melhor custo para se chegar ao estado objetivo final.

f(n)= g(n)+ h(n)	(1)

h(n)= Custo de n até o objetivo pelo caminho
 
Para o nosso problema proposto, o limite para a primeira iteração é a heurística estimada para o estado inicial, e o limite para cada movimento subsequente.
Como estratégia usaremos como técnica principal a de "busca gulosa". Observando o que aconteceu de errado na primeira melhor escolha da busca gulosa, podemos quantificar com uma métrica apropriada da heurística "gulosa", que é conhecida como Correlação da Classificação à Distância Objetivo (do inglês, GDRC).

Teremos um estado inicial onde nossa peça principal para os movimentos é o bloco vazio. E ela só se movimenta nas adjacências, conforme já explicado. 
Precisaremos aplicar um modelo de transição para os movimentos, onde o objetivo é alcançar a configuração da figura 1.


3. DESENVOLVIMENTO DA APLICAÇÃO
Para a nossa aplicação usaremos como código a linguagem Java, e através de sua biblioteca java.util, faremos as manipulações algébricas necessárias.
Vamos então às hipóteses, onde primeiro é preciso realizar um teste de objetivo para sabermos se um dos estados já está na posição “objetivo”. Uma função de custo nos dará um valor numérico para mensurar o custo do passo a executar, avaliando-o por outra função. 

3.1  Estado inicial
Para nossa implementação será gerada a matriz 3x3 através de uma função. Necessitamos de duas matriz, uma que será o nosso objetivo final, e outra onde os números de 0 a 8 serão dispostos aleatoriamente; apresentando o quadro matriz para conclusões dos movimentos.

3.2  Movimentos de transição
Para realizar os movimentos outra função movetabuleiro terá como objetivo realizar os movimentos possíveis. Outra função será responsável para determinar o custo dos movimentos customovimento, e decidir qual deles será executado naquele passo. Então, recursivamente realizar os movimentos e checar se o objetivo foi alcançado. 

3.3  Objetivo alcançado
Quando identificado que o objetivo foi alcançado, o loop para, e será gerado a imagem do resultado e o número de iterações/passos realizado para aquele estado inicial randômico definido. 

4. CONCLUSÕES
Conclusão.

REFERÊNCIAS
Lista de referências:
Parberry, I (1995). Problems on Algorithms, Pearson.
Russell, S Norvig, P (1995). Artificial Intelligence, a modern approach, PrenticeHall.  


