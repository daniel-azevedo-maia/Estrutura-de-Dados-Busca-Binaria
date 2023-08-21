import java.util.Scanner;

public class BinarySearchImpl {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numeros = new int[]{1, 2, 4, 20, 34, 43, 45, 47, 48, 49, 60, 64, 65, 67};

        System.out.print("Informe o número que deseja encontrar: ");
        int numParaBuscar = input.nextInt();

        input.close();

        int indice = encontraIndiceBuscaBinaria(numeros, numParaBuscar);

        // Verifica se o número foi encontrado e imprime a mensagem correspondente.
        if (indice == -1) {
            System.out.println("Não foi possível encontrar o número!");
        } else {
            System.out.printf("O índice do número %d é: %d", numParaBuscar, indice);
        }

    }

    /**
     * Realiza busca binária no array fornecido para encontrar o índice do número especificado.
     *
     * @param numeros - array de inteiros onde a busca será realizada.
     * @param num - número que estamos tentando encontrar.
     * @return índice do número no array ou -1 se não for encontrado.
     *
     */
    private static int encontraIndiceBuscaBinaria(int[] numeros, int num) {

        int inicio = 0; // Inicializa o início do intervalo de busca.
        int fim = numeros.length - 1; // Inicializa o fim do intervalo de busca.
        int meio;

        while (inicio <= fim) {

            // Calcula o ponto médio de forma segura para evitar overflows.
            meio = inicio + (fim - inicio) / 2;

            int chute = numeros[meio]; // Valor atual no índice do meio.

            if (chute == num) {
                return meio; // O número foi encontrado, retorna o índice.
            } else if (chute < num) {
                inicio = meio + 1; // Ajusta o início do intervalo para a metade direita.
            } else {
                fim = meio - 1; // Ajusta o fim do intervalo para a metade esquerda.
            }
        }

        return -1; // O número não foi encontrado no array.

    }
}