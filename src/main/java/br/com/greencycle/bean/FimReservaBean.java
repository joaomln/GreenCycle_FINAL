package br.com.greencycle.bean;

import br.com.greencycle.model.Bike;
import br.com.greencycle.model.Usuario;
import br.com.greencycle.model.Reserva;
import br.com.greencycle.model.Empresa;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FimReservaBean {
    private Integer cdReserva;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtRetirada;
    private Usuario usuario;
    private Bike bike;
    private Empresa empresaRetirada;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{notNull}")
    private LocalDate dtRetorno;

    @NotNull(message = "{notNull}")
    private Empresa empresaDevolucao;

    public static FimReservaBean fromReserva(Reserva reserva) {
        return new FimReservaBean(
                reserva.getCdReserva(),
                reserva.getDtRetirada(),
                reserva.getUsuario(),
                reserva.getBike(),
                reserva.getEmpresaRetirada(),
                LocalDate.now(),
                null);
    }
}
