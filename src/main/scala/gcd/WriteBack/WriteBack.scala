package f_stage
import chisel3._

class WriteBack extends Module{
    val io=IO(new Bundle{
        val alu_data=Input(SInt(32.W))
        val mem_data=Input(SInt(32.W))
        val load_en=Input(Bool())
        val out=Output(SInt(32.W))
    })
    io.out:=Mux(io.load_en,io.mem_data,io.alu_data)
}