JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
BINDIR = bin
SRCDIR = src
JAVA = usr/bin/java
$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

classes= BTQueueNode.class BTQueue.class \
	 BinaryTreeNode.class BinaryTree.class \
         BinarySearchTree.class \
         Vaccine.class VaccineBST.class VaccineBSTApp.class \
         VaccineArray.class VaccineArrayApp.class VaccineTest.class
CLASS_FILES = $(classes:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

runArr: $(CLASS_FILES)
	java -cp $(BINDIR) VaccineArrayApp

runBST: $(CLASS_FILES)
	java -cp $(BINDIR) VaccineBSTApp

runTest: $(CLASS_FILES)
	java -cp $(BINDIR) VaccineTest

