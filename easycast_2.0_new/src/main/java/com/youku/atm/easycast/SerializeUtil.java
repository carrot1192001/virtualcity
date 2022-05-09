package com.youku.atm.easycast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil
{
  public static byte[] serialize(Object object)
    throws IOException
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(object);
    return baos.toByteArray();
  }

  public static Object unserialize(byte[] bytes) throws IOException, ClassNotFoundException {
    if ((bytes != null) && (bytes.length != 0)) {
      ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
      ObjectInputStream ois = new ObjectInputStream(bais);
      return ois.readObject();
    }
    throw new IllegalArgumentException("反序列化对象时，传入空bytes数组");
  }
}