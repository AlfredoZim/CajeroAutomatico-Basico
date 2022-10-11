package cajeroautomatico;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cuenta {

    DecimalFormat df = new DecimalFormat("#########.##");
    private String movimientos = ".....:::   MOVIMIENTOS REGISTRADOS   :::.....\n";
    private Double saldo = 1000.0;
    SimpleDateFormat ff = new SimpleDateFormat("d MMM yyyy HH:mm:ss");

    Cuenta() {
    }

    public String getConsulta() {
        movimientos += "\n" + ff.format(new Date()) + " - Consulta de movimientos";
        return "Saldo actual $" + df.format(saldo);
    }

    public String getMovimientos() {
        return movimientos;
    }

    public String retiroEfectivo(Double retiro) {
        String msj = "No se tienen fondos suficientes!\nSaldo: $" + df.format(saldo);
        Double saldoAnterior = saldo;
        if (saldo != 0 && saldo > retiro) {
            saldo -= retiro;
            msj = "\nUsted está retirando $" + df.format(retiro);
            movimientos += "\n" + ff.format(new Date()) + " - Retiro de efectivo: $"+ df.format(retiro)+"\n\t\t\tSaldo anterior: $"+df.format(saldoAnterior);
        }
        return msj;
    }

}
