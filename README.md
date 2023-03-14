# Tutorial para clonar um repositório git, alterar endereço remoto e fazer push

Projeto relativo à resolução das questões da lista de exercício. Para utilizar e submeter a resolução da lista, o discente deve realizar um clone 
do repositório para o computador que deseja realizar a atividade. Após efetuar o ato de clonar o repositório, ainda no mesmo, mude o git remote para
um repositório da sua conta.

Este tutorial irá guiá-lo através dos passos para clonar um repositório git, alterar o endereço remoto para um repositório diferente e fazer push das suas modificações registradas em um commit.

## Clonando o repositório Git

Para clonar um repositório Git, siga os seguintes passos:

1. Abra o terminal ou prompt de comando em seu computador.
2. Navegue até o diretório onde você deseja clonar o repositório.
3. Digite o seguinte comando: git clone [url do repositório]. Substitua [url do repositório] pelo URL do repositório Git que você deseja clonar.

Exemplo:

```
git clone https://github.com/gugs/myrepor.git
```

4. Aguarde enquanto o Git clona o repositório em seu diretório.

## Alterando o endereço remoto do repositório clonado

Depois de clonar o repositório, você pode querer alterar o endereço remoto para apontar para um repositório diferente. Para fazer isso, siga os seguintes passos:

1. Abra o terminal ou prompt de comando.
2. Navegue até o diretório do repositório clonado.
3. Digite o seguinte comando: git remote set-url origin [novo endereço remoto]. Substitua [novo endereço remoto] pelo URL do novo repositório que você deseja usar.

Exemplo:
```
git remote set-url origin https://github.com/seuusuario/novorepositorio.git
```
4. Verifique se o novo endereço remoto foi configurado corretamente com o seguinte comando: git remote -v.

## Fazendo push das modificações registradas em um commit

Depois de fazer alterações no repositório clonado, você precisará fazer push dessas modificações para o repositório remoto. Para fazer isso, siga os seguintes passos:

1. Abra o terminal ou prompt de comando.
2. Navegue até o diretório do repositório clonado.
3. Digite o seguinte comando: git add [arquivos modificados]. Substitua [arquivos modificados] pelos nomes dos arquivos que você modificou.

```
git add RespostaListaExercicio.java
```
ou

```
git add . (Para adicionar todos os arquivos modificados numa só vez)
```

4. Faça commit das suas modificações com o seguinte comando: git commit -m "[mensagem do commit]". Substitua [mensagem do commit] por uma mensagem que descreva as modificações que você fez.

Exemplo:

```
git commit -m "Adicionado um novo parágrafo na página inicial"
```

5. Finalmente, faça push das suas modificações para o repositório remoto com o seguinte comando: git push.

Exemplo:

```
git push
```

6. Insira suas credenciais do Github para confirmar o push.

Pronto! Agora você clonou um repositório Git, alterou o endereço remoto para um repositório diferente e fez push das suas modificações registradas em um commit.

## OBSERVAÇÕES FINAIS 

Após realizar os procedimentos acima destacados, você deverá compartilha o link do seu repositório resposta por meio de um Google Forms a ser disponibilizado via Classroom.
