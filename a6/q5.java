class MyHashMap {
    final ListNode[] result = new ListNode[10000];
    
    int getIndex(int key) { 
          return Integer.hashCode(key) % result.length;
    }
    
    ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }
    
        public void put(int key, int value) {
            int i = getIndex(key);
            if (result[i] == null)
                result[i] = new ListNode(-1, -1);
            ListNode prev = find(result[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key) {
            int i = getIndex(key);
            if (result[i] == null)
                return -1;
            ListNode node = find(result[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = getIndex(key);
            if (result[i] == null) return;
            ListNode prev = find(result[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
