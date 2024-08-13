uint32_t reverseBits(uint32_t n) {
    uint32_t reversed = 0;
    uint32_t mask = 1;
    for (int i = 0; i < 32; i++) {
        reversed = reversed | (((n >> i) & mask) << (31 - i));
        // printf("%d\n", reversed);
    }
    return reversed;
}