//Mateusz Zaj¹c @ zajacmp3
//17 July 2012
//zajac [at] interia [dot] eu



Install into plugins/

Permision nodes

  indestructibletools.*:
    description: Gives access to all functions
    children:
      indestructibletools.armor: true
      indestructibletools.tools: true
  indestructibletools.armor:
    description: Prevents armor from beeing destroy.
    default: op
  indestructibletools.tools:
    description: Prevents tools from beeing destroyed.
    default: op