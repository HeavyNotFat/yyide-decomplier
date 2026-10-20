import org.objectweb.asm.*;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class StripAnnotations {

    public static void main(String[] args) throws Exception {
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);

        try (ZipInputStream zin = new ZipInputStream(new BufferedInputStream(Files.newInputStream(source)));
             ZipOutputStream zout = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(target)))) {
            ZipEntry entry;
            byte[] buf = new byte[8192];
            while ((entry = zin.getNextEntry()) != null) {
                ByteArrayOutputStream data = new ByteArrayOutputStream();
                int n;
                while ((n = zin.read(buf)) > 0) data.write(buf, 0, n);
                byte[] bytes = data.toByteArray();
                if (entry.getName().endsWith(".class")) {
                    ClassReader reader;
                    try {
                        reader = new ClassReader(bytes);
                    } catch (Throwable t) {
                        System.out.println("BAD CLASS: " + entry.getName() + " -> " + t);
                        continue;
                    }
                    ClassWriter writer = new ClassWriter(0);
                    try {
                    reader.accept(new ClassVisitor(Opcodes.ASM9, writer) {
                        @Override
                        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
                            return null;
                        }

                        @Override
                        public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath path,
                                                                    String desc, boolean visible) {
                            return null;
                        }

                        @Override
                        public FieldVisitor visitField(int access, String name, String desc,
                                                       String signature, Object value) {
                            FieldVisitor fv = super.visitField(access, name, desc, signature, value);
                            if (fv == null) return null;
                            return new FieldVisitor(Opcodes.ASM9, fv) {
                                @Override
                                public AnnotationVisitor visitAnnotation(String d, boolean v) { return null; }
                                @Override
                                public AnnotationVisitor visitTypeAnnotation(int t, TypePath p, String d, boolean v) { return null; }
                            };
                        }

                        @Override
                        public MethodVisitor visitMethod(int access, String name, String desc,
                                                         String signature, String[] exceptions) {
                            MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                            if (mv == null) return null;
                            return new MethodVisitor(Opcodes.ASM9, mv) {
                                @Override
                                public AnnotationVisitor visitAnnotation(String d, boolean v) { return null; }
                                @Override
                                public AnnotationVisitor visitTypeAnnotation(int t, TypePath p, String d, boolean v) { return null; }
                                @Override
                                public AnnotationVisitor visitParameterAnnotation(int p, String d, boolean v) { return null; }
                                @Override
                                public AnnotationVisitor visitInsnAnnotation(int t, TypePath p, String d, boolean v) { return null; }
                                @Override
                                public AnnotationVisitor visitTryCatchAnnotation(int t, TypePath p, String d, boolean v) { return null; }
                                @Override
                                public AnnotationVisitor visitLocalVariableAnnotation(int t, TypePath p, Label[] s, Label[] e, int[] i, String d, boolean v) { return null; }
                            };
                        }
                    }, 0);
                    } catch (Throwable t) {
                        System.out.println("BAD CLASS: " + entry.getName() + " -> " + t);
                        continue;
                    }
                    zout.putNextEntry(new ZipEntry(entry.getName()));
                    zout.write(writer.toByteArray());
                    zout.closeEntry();
                } else {
                    zout.putNextEntry(new ZipEntry(entry.getName()));
                    zout.write(bytes);
                    zout.closeEntry();
                }
            }
        }
        System.out.println("done");
    }
}
