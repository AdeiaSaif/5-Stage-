package f_stage
import chisel3._


class RegFD extends Module{
    val io=IO(new Bundle{
        val pc=Input(SInt(32.W))
        val inst=Input(UInt(32.W))

        val pc_out=Output(SInt(32.W))
        val inst_out=Output(UInt(32.W))
    })
   
    val pc =RegInit(0.S(32.W))
    val inst =RegInit(0.U(32.W))
    
    pc:=io.pc
    inst:=io.inst
    
    io.pc_out:=pc
    io.inst_out:=inst
    
}