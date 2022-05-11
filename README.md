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

![image](https://user-images.githubusercontent.com/68820364/167832690-a53d327b-117a-455f-a61a-f5118b7a8546.png)

# Example block.yml without deps

![image](https://user-images.githubusercontent.com/68820364/167832737-130d87da-ca5a-4c34-8f19-ba4ccd9bf709.png)

# An extension main class requires 2 static methods (load() and block()) 
![image](https://user-images.githubusercontent.com/68820364/167746626-24efd9f3-9be7-42f8-ae1d-4d2a0e874647.png)

The load() method loads the extension (Can contain nothing or a simple load message or anything really)
The block() method provides the CodeBlock instance the extension makes. THIS IS MADE AFTER THE load() METHOD IS EXECUTED!
