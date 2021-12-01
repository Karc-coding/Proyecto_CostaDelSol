import { Empleado } from "./empleado.model";
import { Habitacion } from "./habitacion.model";
import { Huesped } from "./huesped.model";

export class Factura {

	numFactura?: String;
	ruc?: String;
	dni?: Huesped;
	habitacionId?: Habitacion;
	empleadoId?: Empleado;
	precioNoche?: any;
	fec_Act?: Date

}
