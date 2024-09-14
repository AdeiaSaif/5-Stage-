circuit PC :
  module PC :
    input clock : Clock
    input reset : UInt<1>
    input io_pre_pc : SInt<32>
    input io_imm : SInt<32>
    output io_pc_out : SInt<32>

    reg pc : SInt<32>, clock with :
      reset => (UInt<1>("h0"), pc) @[PC.scala 9:19]
    node _pc_T = add(io_pre_pc, io_imm) @[PC.scala 10:18]
    node _pc_T_1 = tail(_pc_T, 1) @[PC.scala 10:18]
    node _pc_T_2 = asSInt(_pc_T_1) @[PC.scala 10:18]
    io_pc_out <= pc @[PC.scala 11:14]
    pc <= mux(reset, asSInt(UInt<32>("h0")), _pc_T_2) @[PC.scala 9:19 PC.scala 9:19 PC.scala 10:7]
