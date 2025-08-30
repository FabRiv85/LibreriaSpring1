import { Cliente } from "./cliente.model";

export interface Factura{
    idFactura: number
    numFactura: string
    fecha: Date
    totalNeto: number;
    iva: number
    total: number
    cliente: Cliente
}