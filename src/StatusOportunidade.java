 public class StatusOportunidade {
     public enum Status {
         NOVO_LEAD,
         CONTATO_REALIZADO,
         TEST_DRIVE,
         PROPOSTA_FINANCIAMENTO,
         GANHO,
         PERDIDO
     }

     private Status status = Status.NOVO_LEAD;

     public void alterarstatus(Status novoStatus) {
         // Usa 'this.status' para verificar o estado atual do objeto
         if (this.status == Status.NOVO_LEAD && novoStatus == Status.CONTATO_REALIZADO) {
             this.status = novoStatus;
         } else if (this.status == Status.CONTATO_REALIZADO && novoStatus == Status.TEST_DRIVE) {
             this.status = novoStatus;
         } else if (this.status == Status.TEST_DRIVE && novoStatus == Status.PROPOSTA_FINANCIAMENTO) {
             this.status = novoStatus;
         } else if (this.status == Status.PROPOSTA_FINANCIAMENTO && novoStatus == Status.GANHO) {
             this.status = novoStatus;
         } else if (novoStatus == Status.PERDIDO) {
             this.status = novoStatus;
         } else {
             System.out.println("Mudança de Status não permitida!");
         }
     }

     public Status getStatus() {
         return this.status;
     }
}




