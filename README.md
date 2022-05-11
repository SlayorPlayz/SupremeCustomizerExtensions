# SupremeCustomizerExtensions

All extensions must have a block.yml file to be loaded!

Block.yml properties:

Property - Descriptiom - Required

main - Main class name - YES
api-version: - API Version the extension uses - YES
version - Version of the extension - YES
name - Name of the extension - YES
dependencies - Dependencies of the extension - NO

# Example block.yml with deps

main: com.slayorplayz.supremecustomizerextension.Test
api-version: '0.1-1'
version: '1.0'
name: 'Tester'
dependencies:
  - SupremeBanks

# Example block.yml without deps

main: com.slayorplayz.supremecustomizerextension.Test
api-version: '0.1-1'
version: '1.0'
name: 'Tester'

# An extension main class requires 2 static methods (load() and block()) 
![image](https://user-images.githubusercontent.com/68820364/167746626-24efd9f3-9be7-42f8-ae1d-4d2a0e874647.png)

The load() method loads the extension (Can contain nothing or a simple load message or anything really)
The block() method provides the CodeBlock instance the extension makes. THIS IS MADE AFTER THE load() METHOD IS EXECUTED!
